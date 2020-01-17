package com.bsmlima.cloud.calculator;

import com.bsmlima.cloud.calculator.operation.Operation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class CalculatorServlet extends HttpServlet {

    private CalculatorService calculatorService;

    public CalculatorServlet() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        calculatorService = ac.getBean("calculatorService", CalculatorService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        double num1 = Double.parseDouble(req.getParameter("num1"));
        double num2 = Double.parseDouble(req.getParameter("num2"));
        Operation.Operations op = Operation.Operations.valueOf(req.getParameter("op").toUpperCase());

        resp.setContentType("text/json");
        PrintWriter printWriter = resp.getWriter();
        printWriter.print(calculatorService.calculate(op, num1, num2));
        printWriter.close();
    }
}
