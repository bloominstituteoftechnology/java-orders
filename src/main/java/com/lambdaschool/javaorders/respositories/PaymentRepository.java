package com.lambdaschool.javaorders.respositories;

import com.lambdaschool.javaorders.models.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
