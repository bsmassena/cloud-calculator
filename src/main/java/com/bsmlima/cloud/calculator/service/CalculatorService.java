package com.bsmlima.cloud.calculator.service;

import com.bsmlima.cloud.calculator.operation.*;
import com.google.inject.Inject;
import com.google.inject.Provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CalculatorService {
    @Inject
    private Map<Operation.Operations, Provider<Operation>> operations;
    private List<Operation> history = new ArrayList<>();

    public double calculate(Operation.Operations op, double num1, double num2) {
        Operation operation = operations.get(op).get();
        operation.setNum1(num1);
        operation.setNum2(num2);
        history.add(operation);
        return operation.calculate();
    }

    public List<Operation> getHistory() {
        return this.history;
    }
}
