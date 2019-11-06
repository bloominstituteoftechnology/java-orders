package com.stepasha.javaorders.services;

import com.stepasha.javaorders.models.Customers;
import com.stepasha.javaorders.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomersRepository custRepo;

    @Override
    public List<Customers> findAll() {
        List<Customers> list = new ArrayList<>();
        custRepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Customers findCustomerById(long id) {
        return custRepo.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
    }

    @Override
    public List<Customers> findCustomerByNameLike(String thename) {
        return custRepo.findByNameContainingIgnoringCase(thename);
    }
}
