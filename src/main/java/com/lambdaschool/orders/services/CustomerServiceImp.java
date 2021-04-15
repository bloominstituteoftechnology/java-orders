package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "CustomerService")
public class CustomerServiceImp implements CustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public List<Customer> findAllCustomerOrders() {
        List<Customer> list = new ArrayList<>();
        customerRepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Customer findCustomerById(long id) {
        return customerRepo.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Customer " + id + " Not Found!" ));
    }

    @Override
    public List<Customer> findByNameLike(String substring) {
        List<Customer> returnList = customerRepo.findByCustnameContainingIgnoringCase(substring);
        return returnList;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Customer update(Customer customer, long id) {
        return null;
    }
}
