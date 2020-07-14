package com.lambdaschool.javaorders.respositories;

import com.lambdaschool.javaorders.model.Customers;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomersRepository extends CrudRepository<Customers, Long> {
    List<Customers> findByCustnameContainingIgnoringCase(String likename);

}