package com.stepasha.javaorders.repository;

import com.stepasha.javaorders.models.Customers;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CustomersRepository extends CrudRepository<Customers, Long> {

    ArrayList<Customers> findByStateIgnoringCase(String state);

    ArrayList<Customers> findByNameContainingIgnoringCase(String likename);
}
