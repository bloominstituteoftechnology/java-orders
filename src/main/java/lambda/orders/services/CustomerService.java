package lambda.orders.services;

import lambda.orders.models.Customer;

import java.util.List;

public interface CustomerService
{
	List<Customer> findAll();

	Customer findCustomerById(long id);

	Customer findCustomerByName(String name);

	void delete(long id);

	Customer save(Customer customer);

	Customer update(Customer customer, long id);
}
