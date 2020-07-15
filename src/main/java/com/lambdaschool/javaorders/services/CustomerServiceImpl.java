package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Customer;
import com.lambdaschool.javaorders.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    private CustomerRepository customerrepos;

    @Override
    public Customer save(Customer customer)
    {
        return customerrepos.save(customer);
    }

    @Override
    public List<Customer> listAllCustomersOrders()
    {
        List<Customer> rtn = new ArrayList<>();
        customerrepos.findAll()
            .iterator().forEachRemaining(rtn::add);

        return rtn;
    }

    @Override
    public Customer FindById(long id)
    {
        return customerrepos.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Customer ID: " + id + " is not found. Please try another"));
    }

    @Override
    public List<Customer> findBySubname(String subname)
    {
        List<Customer> rtn = new ArrayList<>();
        rtn = customerrepos.findByCustnameContainingIgnoringCase(subname);
        if(rtn == null){
            throw new EntityNotFoundException("Customer with the name " + subname + " is not found");
        }
        return rtn;
    }
}
