package com.lambdaschool.lambdaorders.services;

import com.lambdaschool.lambdaorders.models.Agent;
import com.lambdaschool.lambdaorders.models.Customer;
import com.lambdaschool.lambdaorders.repositories.AgentRepository;
import com.lambdaschool.lambdaorders.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService
    {
        @Autowired
        private CustomerRepository customerrepos;

        @Override
        public List<Customer> findAllCustomers()
        {
            List<Customer> tempList = new ArrayList<>();
            customerrepos.findAll().iterator().forEachRemaining(tempList::add);
            return tempList;
        }

        @Override
        public List <Customer> findByCustomerName(String customername)
        {
            return customerrepos.findByCustomerNameContainingIgnoringCase(customername);
        }

        @Override
        public  Customer findCustomerById(long id) throws EntityNotFoundException
        {
            return customerrepos.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer " + id + " Not Found"));
        }
    }

