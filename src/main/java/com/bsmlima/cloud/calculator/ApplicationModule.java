package com.bsmlima.cloud.calculator;

import com.bsmlima.cloud.calculator.operation.*;
import com.bsmlima.cloud.calculator.service.CalculatorService;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;

public class ApplicationModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(CalculatorService.class);

        MapBinder<Operation.Operations, Operation> bathMapBinder =
                MapBinder.newMapBinder(binder(), Operation.Operations.class, Operation.class);
        bathMapBinder.addBinding(Operation.Operations.DIV).to(DivOperation.class);
        bathMapBinder.addBinding(Operation.Operations.MUL).to(MulOperation.class);
        bathMapBinder.addBinding(Operation.Operations.POW).to(PowOperation.class);
        bathMapBinder.addBinding(Operation.Operations.SUB).to(SubOperation.class);
        bathMapBinder.addBinding(Operation.Operations.SUM).to(SumOperation.class);
    }
}
