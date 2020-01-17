package com.bsmlima.cloud.calculator;

import com.bsmlima.cloud.calculator.operation.Operation;
import com.bsmlima.cloud.calculator.service.CalculatorService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.reactivex.netty.protocol.http.server.HttpServerRequest;
import io.reactivex.netty.protocol.http.server.HttpServerResponse;
import io.reactivex.netty.protocol.http.server.RequestHandler;
import netflix.karyon.transport.http.health.HealthCheckEndpoint;
import rx.Observable;

public class RxNettyHandler implements RequestHandler<ByteBuf, ByteBuf> {

    private final String historyUri = "/history";
    private final String healthCheckUri;
    private final HealthCheckEndpoint healthCheckEndpoint;
    private final String URI_ERROR_MESSAGE = "{\"Error\":\"Please provide a valid URI. The URI should be /{op}/{a}/{b}\"}";
    private final String DIV_BY_ZERO_ERROR_MESSAGE = "{\"Error\":\"Division by 0 not supported\"}";
    private final int OPERATION_PARAM_INDEX = 0;
    private final int NUM1_PARAM_INDEX = 1;
    private final int NUM2_PARAM_INDEX = 2;

    private CalculatorService calculatorService;
    private Gson gson = new GsonBuilder().create();

    public RxNettyHandler(String healthCheckUri, HealthCheckEndpoint healthCheckEndpoint, CalculatorService calculatorService) {
        this.healthCheckUri = healthCheckUri;
        this.healthCheckEndpoint = healthCheckEndpoint;
        this.calculatorService = calculatorService;
    }

    @Override
    public Observable<Void> handle(HttpServerRequest<ByteBuf> request, HttpServerResponse<ByteBuf> response) {
        String uri = request.getUri();

        if (uri.startsWith(healthCheckUri)) return healthCheckEndpoint.handle(request, response);

        if (uri.startsWith(historyUri)) {
            return response.writeStringAndFlush(gson.toJson(calculatorService.getHistory()));
        }

        String[] params = uri.substring(1).split("/", 0);

        if (params.length != 3) {
            response.setStatus(HttpResponseStatus.BAD_REQUEST);
            return response.writeStringAndFlush(URI_ERROR_MESSAGE);
        }

        Operation.Operations op = Operation.Operations.valueOf(params[OPERATION_PARAM_INDEX].toUpperCase());
        double num1 = Double.parseDouble(params[NUM1_PARAM_INDEX]);
        double num2 = Double.parseDouble(params[NUM2_PARAM_INDEX]);

        try {
            double result = calculatorService.calculate(op, num1, num2);
            return response.writeStringAndFlush(String.format("{\"Result\":\"%f\"}", result));
        } catch (ArithmeticException exception) {
            response.setStatus(HttpResponseStatus.BAD_REQUEST);
            return response.writeStringAndFlush(String.format("{\"Error\":\"%s\"}", exception.getMessage()));
        }
    }
}