package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.model.Customers;
//import com.lambdaschool.javaorders.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private com.lambdaschool.javaorders.repositories.CustomersRepository customerRepository;

    @Override
    public List<Customers> findAllCustomers() {
        List<Customers> customerList = new ArrayList<>();
        customerRepository.findAll().iterator().forEachRemaining(customerList::add);
        return customerList;
    }

    @Override
    public Customers findCustomerById(long id) {
        return customerRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Customer "+id+" Not Found"));
    }

    @Override
    public List<Customers> findByNameLike(String thename) {
        return customerRepository.findByCustnameContainingIgnoringCase(thename);
    }


}