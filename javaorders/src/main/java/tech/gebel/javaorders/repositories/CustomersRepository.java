package tech.gebel.javaorders.repositories;

import org.springframework.data.repository.CrudRepository;
import tech.gebel.javaorders.models.Customer;

public interface CustomersRepository extends CrudRepository<Customer, Long> {}
