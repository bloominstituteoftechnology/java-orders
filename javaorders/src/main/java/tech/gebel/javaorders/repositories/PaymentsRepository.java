package tech.gebel.javaorders.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import tech.gebel.javaorders.models.Payment;

@Component
public interface PaymentsRepository extends CrudRepository<Payment, Long> {}
