package com.lambda.orders.servicers;

import com.lambda.orders.models.Customer;
import com.lambda.orders.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "customerService")
public class CustomerServicesImpl implements CustomerServices{

    @Autowired
    CustomersRepository custrepos;

    @Override
    public Customer save(Customer customer) {
        return custrepos.save(customer);
    }
}
