package lambda.orders.services;

import lambda.orders.models.Customer;
import lambda.orders.models.Order;
import lambda.orders.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	private CustomerRepo custrepos;

	@Override
	public List<Customer> findAll()
	{
		ArrayList<Customer> customers = new ArrayList<>();
		custrepos.findAll().iterator().forEachRemaining(customers::add);
		return customers;
	}

	@Override
	public Customer findCustomerById(long id) throws EntityNotFoundException
	{
		return custrepos.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
	}

	@Override
	public Customer findCustomerByName(String name) throws EntityNotFoundException
	{
		Customer customer = custrepos.findByCustname(name);

		if (customer == null)
		{
			throw new EntityNotFoundException("Customer " + name + " not found");
		}

		return customer;
	}

	@Override
	public void delete(long id) throws EntityNotFoundException
	{
		if(custrepos.findById(id).isPresent())
		{
			custrepos.deleteById(id);
		} else {
			throw new EntityNotFoundException(Long.toString(id));
		}
	}

	@Transactional
	@Override
	public Customer save(Customer customer)
	{
		Customer newCustomer = new Customer();

		newCustomer.setCustname(customer.getCustname());
		newCustomer.setCustcity(customer.getCustcity());
		newCustomer.setWorkingarea(customer.getWorkingarea());
		newCustomer.setCustcountry(customer.getCustcountry());
		newCustomer.setGrade(customer.getGrade());
		newCustomer.setOpeningamt(customer.getOpeningamt());
		newCustomer.setReceiveamt(customer.getReceiveamt());
		newCustomer.setPaymentamt(customer.getPaymentamt());
		newCustomer.setOutstandingamt(customer.getOutstandingamt());
		newCustomer.setPhone(customer.getPhone());
		newCustomer.setAgent(customer.getAgent());

		for (Order o: customer.getOrders())
		{
			newCustomer.getOrders().add(
					new Order(o.getOrdamount(),
							o.getAdvanceamount(),
							o.getCustomer(),
							o.getAgent(),
							o.getOrddescription()));
		}

		return custrepos.save(newCustomer);
	}

	@Transactional
	@Override
	public Customer update(Customer customer, long id) throws EntityNotFoundException
	{
		Customer currentCustomer = custrepos.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

		if(customer.getCustname() != null)
		{
			currentCustomer.setCustname(customer.getCustname());
		}

		if(customer.getCustcity() != null)
		{
			currentCustomer.setCustcity(customer.getCustcity());
		}

		if(customer.getWorkingarea() != null)
		{
			currentCustomer.setWorkingarea(customer.getWorkingarea());
		}

		if(customer.getCustcountry() != null)
		{
			currentCustomer.setCustcountry(customer.getCustcountry());
		}

		if(customer.getGrade() != null)
		{
			currentCustomer.setGrade(customer.getGrade());
		}

		if(customer.getOpeningamt() != currentCustomer.getOpeningamt())
		{
			currentCustomer.setOpeningamt(customer.getOpeningamt());
		}

		if(customer.getReceiveamt() != currentCustomer.getReceiveamt())
		{
			currentCustomer.setReceiveamt(customer.getReceiveamt());
		}

		if(customer.getPaymentamt() != currentCustomer.getPaymentamt())
		{
			currentCustomer.setPaymentamt(customer.getPaymentamt());
		}

		if(customer.getOutstandingamt() != currentCustomer.getOutstandingamt())
		{
			currentCustomer.setOutstandingamt(customer.getOutstandingamt());
		}

		if(customer.getPhone() != null)
		{
			currentCustomer.setPhone(customer.getPhone());
		}

		if(customer.getAgent() != null)
		{
			currentCustomer.setAgent(customer.getAgent());
		}

		if(customer.getOrders().size() > 0)
		{
			for (Order o: customer.getOrders())
			{
				currentCustomer.getOrders().add(
						new Order(o.getOrdamount(),
								o.getAdvanceamount(),
								currentCustomer,
								currentCustomer.getAgent(),
								o.getOrddescription()));
			}
		}

		return custrepos.save(currentCustomer);
	}
}
