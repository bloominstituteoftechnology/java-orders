package com.lambda.javaorders.respositories;

import com.lambda.javaorders.models.Payments;
import org.springframework.data.repository.CrudRepository;

public interface PaymentsRepository extends CrudRepository <Payments, Long> {
}
