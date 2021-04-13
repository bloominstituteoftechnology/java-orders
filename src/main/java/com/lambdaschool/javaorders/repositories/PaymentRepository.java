package com.lambdaschool.javaorders.repositories;

import com.lambdaschool.javaorders.models.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long>
{
}
