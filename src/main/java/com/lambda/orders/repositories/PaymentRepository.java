package com.lambda.orders.repositories;

import com.lambda.orders.models.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long>
{
}
