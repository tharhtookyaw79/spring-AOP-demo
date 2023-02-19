package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		// 1. read Spring config java class
		// 2. get the bean from the spring container
		// 3. call the business method
		// 4. close the context

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// call method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts(false);

		// display the accounts
		System.out.println("\n\nMain Program: AfterReturningDemoApp");

		System.out.println("----------");
		System.out.println(theAccounts);
		System.out.println("\n");

		context.close();

	}

}
