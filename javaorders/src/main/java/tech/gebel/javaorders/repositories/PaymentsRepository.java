package tech.gebel.javaorders.repositories;

import org.springframework.data.repository.CrudRepository;
import tech.gebel.javaorders.models.Payment;

public interface PaymentsRepository extends CrudRepository<Payment, Long> {}
