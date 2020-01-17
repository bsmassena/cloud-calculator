package com.bsmlima.cloud.tema06.operation;

public abstract class Operation {
    protected double num1, num2;
    protected Operations operation;

    public enum Operations { SUM, SUB, DIV, MUL, POW }

    public Operation(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public abstract double calculate();

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public Operations getOperation() {
        return operation;
    }
}
