package tech.gebel.javaorders.repositories;

import org.springframework.data.repository.CrudRepository;
import tech.gebel.javaorders.models.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long> {}
