package com.bsmlima.cloud.calculator.operation;

public class PowOperation extends Operation {

    public PowOperation() {
        this.operation = Operations.POW;
    }

    public double calculate() {
        return Math.pow(num1, num2);
    }
}
