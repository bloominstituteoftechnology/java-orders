package com.lambda.javaorders.respositories;

import com.lambda.javaorders.models.Customers;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomersRepositoy extends CrudRepository<Customers, Long> {
    List<Customers> findByCustnameContainingIgnoringCase(String likename);

}
