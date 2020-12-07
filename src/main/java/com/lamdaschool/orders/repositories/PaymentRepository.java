package com.lamdaschool.orders.repositories;

import com.lamdaschool.orders.models.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository
    extends CrudRepository<Payment, Long>
{
}
