package com.lambdaschool.orders.repositories;

import com.lambdaschool.orders.models.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long>
{
}
