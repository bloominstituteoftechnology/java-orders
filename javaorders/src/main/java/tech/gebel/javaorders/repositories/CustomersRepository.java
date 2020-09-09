package tech.gebel.javaorders.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import tech.gebel.javaorders.models.Customer;

@Component
public interface CustomersRepository extends CrudRepository<Customer, Long> {}
