package com.bsmlima.cloud.tema06;

import com.bsmlima.cloud.tema06.operation.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CalculatorServiceTest {
    private static final double DOUBLE_THRESHOLD = 0.0001;

    @Autowired
    private CalculatorService cs;

    @Test
    public void testSum() {
        double result = cs.calculate(Operation.Operations.SUM ,12, 5);
        assertEquals(17, result, DOUBLE_THRESHOLD);
    }

    @Test
    public void testSub() {
        double result = cs.calculate(Operation.Operations.SUB ,12, 5);
        assertEquals(7, result, DOUBLE_THRESHOLD);
    }

    @Test
    public void testDiv() {
        double result = cs.calculate(Operation.Operations.DIV ,7, 2);
        assertEquals(3.5, result, DOUBLE_THRESHOLD);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivByZero() {
        cs.calculate(Operation.Operations.DIV, 5, 0);
    }

    @Test
    public void testMul() {
        double result = cs.calculate(Operation.Operations.MUL, 3, 4);
        assertEquals(12, result, DOUBLE_THRESHOLD);
    }

    @Test
    public void testPow() {
        double result = cs.calculate(Operation.Operations.POW, 4, 3);
        assertEquals(64, result, DOUBLE_THRESHOLD);
    }

    @Test
    public void testHistory() {
        double subResult = cs.calculate(Operation.Operations.SUB, 4, 3);
        double sumResult = cs.calculate(Operation.Operations.SUM, 2, 1);

        assertEquals(Operation.Operations.SUB, cs.getHistory().get(0).getOperation());
        assertEquals(4, cs.getHistory().get(0).getNum1(), DOUBLE_THRESHOLD);
        assertEquals(3, cs.getHistory().get(0).getNum2(), DOUBLE_THRESHOLD);
        assertEquals(1, subResult, DOUBLE_THRESHOLD);

        assertEquals(Operation.Operations.SUM, cs.getHistory().get(1).getOperation());
        assertEquals(2, cs.getHistory().get(1).getNum1(), DOUBLE_THRESHOLD);
        assertEquals(1, cs.getHistory().get(1).getNum2(), DOUBLE_THRESHOLD);
        assertEquals(3, sumResult, DOUBLE_THRESHOLD);
    }
}
