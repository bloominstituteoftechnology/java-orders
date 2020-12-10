package com.lambdaschool.lambdaorders.services;

import com.lambdaschool.lambdaorders.models.Customer;
import com.lambdaschool.lambdaorders.repositories.CustomerRepository;
import com.lambdaschool.lambdaorders.repositories.OrderRepository;
import com.lambdaschool.lambdaorders.repositories.PaymentRepository;
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
        private CustomerRepository custrepos;

        @Autowired
        private PaymentRepository paymentRepository;

        @Autowired
        private OrderRepository orderRepository;

        @Override
        public List<Customer> findAllCustomers()
        {
            List<Customer> tempList = new ArrayList<>();
            custrepos.findAll().iterator().forEachRemaining(tempList::add);
            return tempList;
        }

        @Override
        public List<Customer> findByCustomername(String custname)
        {
            return custrepos.findByCustnameContainingIgnoringCase(custname);
        }

        @Override
        public Customer findCustomersById(long id) throws EntityNotFoundException
        {
            return custrepos.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer " + id + " Not Found"));
        }

    }

