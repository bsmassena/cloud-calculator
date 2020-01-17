package com.bsmlima.cloud.calculator;

import com.bsmlima.cloud.calculator.operation.*;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    public CalculatorService calculatorService() {
        return new CalculatorService();
    }

    @Bean(name = "SUM")
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Operation sumOperation(double num1, double num2) {
        return new SumOperation(num1, num2);
    }

    @Bean(name = "SUB")
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Operation subOperation(double num1, double num2) {
        return new SubOperation(num1, num2);
    }

    @Bean(name = "DIV")
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Operation divOperation(double num1, double num2) {
        return new DivOperation(num1, num2);
    }

    @Bean(name = "MUL")
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Operation mulOperation(double num1, double num2) {
        return new MulOperation(num1, num2);
    }

    @Bean(name = "POW")
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Operation powOperation(double num1, double num2) {
        return new PowOperation(num1, num2);
    }
}
