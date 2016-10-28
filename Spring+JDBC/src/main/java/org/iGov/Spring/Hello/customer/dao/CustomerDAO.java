package org.iGov.Spring.Hello.customer.dao;

import org.iGov.Spring.Hello.customer.Customer;

public interface CustomerDAO {
	public void insertCustomer(Customer customer);
	public Customer findCustomer(int id);
}
