package com.bsmlima.cloud.tema06.operation;

public class SumOperation extends Operation {

    public SumOperation(double num1, double num2) {
        super(num1, num2);
        this.operation = Operations.SUM;
    }

    public double calculate() {
        return num1 + num2;
    }
}
