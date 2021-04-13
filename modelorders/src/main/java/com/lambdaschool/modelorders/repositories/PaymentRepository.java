package com.lambdaschool.modelorders.repositories;

import com.lambdaschool.modelorders.models.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
