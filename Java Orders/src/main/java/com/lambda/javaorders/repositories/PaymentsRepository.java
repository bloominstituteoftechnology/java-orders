package com.lambda.javaorders.repositories;

import com.lambda.javaorders.models.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentsRepository extends CrudRepository <Payment, Long> {
}
