package com.lambdaschool.modelorders.services;

import com.lambdaschool.modelorders.models.Customer;

import java.util.List;

public interface CustomerServices {

  List<Customer> findAllCustomers();
  Customer findCustomerByCustCode(long custcode);
  List <Customer> findCustomerByName(String name);
  List<Customer> findByWorkingArea(String workingrea);
  List<Customer> findByNameLike(String likeName);
  List<Customer> findByGrade(String grade);

  void delete(long custcode);

  Customer update(Customer customer, long custcode);
  Customer save(Customer customer);
  void deleteAllCustomers();
}
