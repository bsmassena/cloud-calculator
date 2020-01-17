package com.bsmlima.cloud.tema06.operation;

public class PowOperation extends Operation {

    public PowOperation(double num1, double num2) {
        super(num1, num2);
        this.operation = Operations.POW;
    }

    public double calculate() {
        return Math.pow(num1, num2);
    }
}
