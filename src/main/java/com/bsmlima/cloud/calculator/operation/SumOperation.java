package com.bsmlima.cloud.calculator.operation;

public class SumOperation extends Operation {

    public SumOperation() {
        this.operation = Operations.SUM;
    }

    public double calculate() {
        return num1 + num2;
    }
}
