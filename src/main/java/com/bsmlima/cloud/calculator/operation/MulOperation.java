package com.bsmlima.cloud.calculator.operation;

public class MulOperation extends Operation {

    public MulOperation() {
        this.operation = Operations.MUL;
    }

    public double calculate() {
        return num1 * num2;
    }
}
