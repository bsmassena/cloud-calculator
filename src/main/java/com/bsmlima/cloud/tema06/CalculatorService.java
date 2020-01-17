package com.bsmlima.cloud.tema06;

import com.bsmlima.cloud.tema06.operation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class CalculatorService {
     private List<Operation> history = new ArrayList<>();
     @Autowired
     private ApplicationContext ac;

     public double calculate(Operation.Operations op, double num1, double num2) {
          Operation operation = (Operation) ac.getBean(op.toString(), num1, num2);
          double result = operation.calculate();
          history.add(operation);
          return result;
     }

     public List<Operation> getHistory() {
          return this.history;
     }
}
