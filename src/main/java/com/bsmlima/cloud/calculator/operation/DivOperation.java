package com.bsmlima.cloud.calculator.operation;

public class DivOperation extends Operation {

    public DivOperation() {
        this.operation = Operations.DIV;
    }

    public double calculate() {
        if(num2 == 0) throw new ArithmeticException("Division by zero");

        return num1 / num2;
    }
}
