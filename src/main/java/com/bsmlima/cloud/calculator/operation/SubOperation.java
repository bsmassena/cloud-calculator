package com.bsmlima.cloud.calculator.operation;

public class SubOperation extends Operation {

    public SubOperation() {
        this.operation = Operations.SUB;
    }

    public double calculate() {
        return num1 - num2;
    }
}
