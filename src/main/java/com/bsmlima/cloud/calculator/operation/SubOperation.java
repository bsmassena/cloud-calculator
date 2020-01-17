package com.bsmlima.cloud.calculator.operation;

public class SubOperation extends Operation {

    public SubOperation(double num1, double num2) {
        super(num1, num2);
        this.operation = Operations.SUB;
    }

    public double calculate() {
        return num1 - num2;
    }
}
