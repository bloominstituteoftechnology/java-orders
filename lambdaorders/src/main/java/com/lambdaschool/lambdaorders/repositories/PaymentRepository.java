package com.lambdaschool.lambdaorders.repositories;

import com.lambdaschool.lambdaorders.models.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long>
{

}
