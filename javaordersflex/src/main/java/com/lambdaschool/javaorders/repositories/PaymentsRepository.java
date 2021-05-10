package com.lambdaschool.javaorders.repositories;

import com.lambdaschool.javaorders.models.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentsRepository extends CrudRepository<Payment, Long> {
}
