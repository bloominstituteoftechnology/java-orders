package com.lambdaschool.javaorders.respositories;

import com.lambdaschool.javaorders.model.Payments;
import org.springframework.data.repository.CrudRepository;

public interface PaymentsRepository extends CrudRepository <Payments, Long> {
}