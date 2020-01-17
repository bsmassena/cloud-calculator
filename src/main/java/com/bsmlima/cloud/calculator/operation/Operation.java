package com.bsmlima.cloud.calculator.operation;

public abstract class Operation {
    protected double num1, num2;
    protected Operations operation;

    public enum Operations { SUM, SUB, DIV, MUL, POW }

    public abstract double calculate();

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public Operations getOperation() {
        return operation;
    }
}
