package com.bsmlima.cloud.calculator;

import com.bsmlima.cloud.calculator.service.CalculatorService;
import com.google.inject.Guice;
import com.google.inject.Injector;
import netflix.adminresources.resources.KaryonWebAdminModule;
import netflix.karyon.Karyon;
import netflix.karyon.KaryonBootstrapModule;
import netflix.karyon.ShutdownModule;
import netflix.karyon.archaius.ArchaiusBootstrapModule;
import netflix.karyon.health.HealthCheckHandler;
import netflix.karyon.servo.KaryonServoModule;
import netflix.karyon.transport.http.health.HealthCheckEndpoint;

public class Main {
	public static void main(String[] args) {
		System.setProperty("java.awt.headless","true");
		System.setProperty("archaius.deployment.environment","dev");

		Injector injector = Guice.createInjector(new ApplicationModule());

		HealthCheckHandler healthCheckHandler = new HealthCheckResource();
		Karyon.forRequestHandler(8888,
				new RxNettyHandler("/healthcheck",
						new HealthCheckEndpoint(healthCheckHandler),
						injector.getInstance(CalculatorService.class)),
				new KaryonBootstrapModule(healthCheckHandler),
				new ArchaiusBootstrapModule("calculator"),
				Karyon.toBootstrapModule(KaryonWebAdminModule.class),
				ShutdownModule.asBootstrapModule(),
				KaryonServoModule.asBootstrapModule()
		).startAndWaitTillShutdown();
	}
}
