package localhost.ealambdaschool.orders.services;

import localhost.ealambdaschool.orders.models.Customer;
import localhost.ealambdaschool.orders.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "customerServices")
public class CustomerServiceImpl implements CustomerServies
{
    @Autowired
    CustomerRepository custrepos;

    @Override
    public Customer save(Customer customer){
        return custrepos.save(customer);
    }
}