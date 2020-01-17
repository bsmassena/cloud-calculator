package com.bsmlima.cloud.tema06.operation;

public class MulOperation extends Operation {

    public MulOperation(double num1, double num2) {
        super(num1, num2);
        this.operation = Operations.MUL;
    }

    public double calculate() {
        return num1 * num2;
    }
}
