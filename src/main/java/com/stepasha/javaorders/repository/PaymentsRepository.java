package com.stepasha.javaorders.repository;

import com.stepasha.javaorders.models.Payments;
import org.springframework.data.repository.CrudRepository;

public interface PaymentsRepository extends CrudRepository<Payments, Long> {
}
