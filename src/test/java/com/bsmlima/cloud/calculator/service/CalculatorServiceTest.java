package com.bsmlima.cloud.calculator.service;

import com.bsmlima.cloud.calculator.ApplicationModule;
import com.bsmlima.cloud.calculator.operation.*;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorServiceTest {
    private static final double DOUBLE_THRESHOLD = 0.0001;

    private CalculatorService cs;

    @Before
    public void init() {
        Injector injector = Guice.createInjector(new ApplicationModule());
        cs = injector.getInstance(CalculatorService.class);
    }

    @Test
    public void testSum() {
        assertEquals(cs.calculate(Operation.Operations.SUM ,12, 5), 17, DOUBLE_THRESHOLD);
    }

    @Test
    public void testSub() {
        assertEquals(cs.calculate(Operation.Operations.SUB ,12, 5), 7, DOUBLE_THRESHOLD);
    }

    @Test
    public void testDiv() {
        assertEquals(cs.calculate(Operation.Operations.DIV ,7, 2), 3.5, DOUBLE_THRESHOLD);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivByZero() {
        cs.calculate(Operation.Operations.DIV, 5, 0);
    }

    @Test
    public void testMul() {
        assertEquals(cs.calculate(Operation.Operations.MUL, 3, 4), 12, DOUBLE_THRESHOLD);
    }

    @Test
    public void testPow() {
        assertEquals(cs.calculate(Operation.Operations.POW, 4, 3), 64, DOUBLE_THRESHOLD);
    }

    @Test
    public void testHistory() {
        cs.calculate(Operation.Operations.SUB, 4, 3);
        cs.calculate(Operation.Operations.SUM, 4, 3);

        assertEquals(2, cs.getHistory().size());

        assertEquals(Operation.Operations.SUB, cs.getHistory().get(0).getOperation());
        assertEquals(Operation.Operations.SUM, cs.getHistory().get(1).getOperation());
    }
}
