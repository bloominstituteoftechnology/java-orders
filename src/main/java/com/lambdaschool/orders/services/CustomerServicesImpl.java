package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customerService")
public class CustomerServicesImpl implements CustomerServices{

    @Autowired
    private CustomersRepository customersRepository;

    @Override
    public List<Customer> findAllCustomers() {
        List<Customer> customerList = new ArrayList<>();
        customersRepository.findAll().iterator().forEachRemaining(customerList::add);
        return customerList;
    }

    @Override
    public Customer findCustomerById(long custcode) {
        Customer customer = customersRepository.findById(custcode)
                .orElseThrow(()->new EntityNotFoundException("Customer "+custcode+" Not Found"));
        return customer;
    }

    @Override
    public List<Customer> findCustomerByNameLike(String subname) {
        List<Customer> customerList = customersRepository.findByCustnameContainingIgnoringCase(subname);
        return customerList;
    }
}
