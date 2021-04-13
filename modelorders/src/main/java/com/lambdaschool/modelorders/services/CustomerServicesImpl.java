package com.lambdaschool.modelorders.services;

import com.lambdaschool.modelorders.models.Customer;

import java.util.List;

public class CustomerServicesImpl implements CustomerServices {


  @Override
  public List<Customer> findAllCustomers() {
    return null;
  }

  @Override
  public Customer findCustomerByCustCode(long custcode) {
    return null;
  }

  @Override
  public List<Customer> findCustomerByName(String name) {
    return null;
  }

  @Override
  public List<Customer> findByWorkingArea(String workingrea) {
    return null;
  }

  @Override
  public List<Customer> findByNameLike(String likeName) {
    return null;
  }

  @Override
  public List<Customer> findByGrade(String grade) {
    return null;
  }

  @Override
  public void delete(long custcode) {

  }

  @Override
  public Customer update(
      Customer customer,
      long custcode) {
    return null;
  }

  @Override
  public Customer save(Customer customer) {
    return null;
  }

  @Override
  public void deleteAllCustomers() {

  }
}
