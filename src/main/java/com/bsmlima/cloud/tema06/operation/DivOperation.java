package com.bsmlima.cloud.tema06.operation;

public class DivOperation extends Operation {

    public DivOperation(double num1, double num2) {
        super(num1, num2);
        this.operation = Operations.DIV;
    }

    public double calculate() {
        if(num2 == 0) throw new ArithmeticException("Division by zero");

        return num1 / num2;
    }
}