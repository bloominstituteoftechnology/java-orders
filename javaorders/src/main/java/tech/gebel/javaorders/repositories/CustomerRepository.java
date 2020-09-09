package tech.gebel.javaorders.repositories;

import org.springframework.data.repository.CrudRepository;
import tech.gebel.javaorders.models.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {}
