package org.iGov.Spring.Hello;

import org.iGov.Spring.Hello.customer.Customer;
import org.iGov.Spring.Hello.customer.dao.CustomerDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		
		
		CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
		//Customer customer = new Customer("Alexxx", "Sexxy", 102); //// creating new CUSTOMER 
		//customerDAO.insertCustomer(customer); 					//// add CUSTOMER to DataBase
		Customer customer1 = customerDAO.findCustomer(2);
		System.out.println(customer1.toString());
	}

}
