package com.lambdaschool.moduleproject.repositories;

import com.lambdaschool.moduleproject.models.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
