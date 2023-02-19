package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

	public static void main(String[] args) {
		// 1. read Spring config java class
		// 2. get the bean from the spring container
		// 3. call the business method
		// 4. close the context

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		myLogger.info("\nMain Program: AroundDemoApp");

		myLogger.info("Calling getFortune");

		boolean tripWire = true;
		String data = theFortuneService.getFortune(tripWire);

		myLogger.info("\nMy Fortune is: " + data);

		myLogger.info("Finished");

		context.close();

	}

}
