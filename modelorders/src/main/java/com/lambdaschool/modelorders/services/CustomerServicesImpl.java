package com.lambdaschool.modelorders.services;

import com.lambdaschool.modelorders.models.Customer;
import com.lambdaschool.modelorders.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerServicesImpl implements CustomerServices {

  @Autowired
  CustomersRepository custrepos;

  @Override
  public Customer save(Customer customer) {
    return custrepos.save(customer);
  }
}
