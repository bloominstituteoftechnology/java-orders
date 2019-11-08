package com.stepasha.javaorders.services;

import com.stepasha.javaorders.models.Payments;

public interface PaymentService {

    Payments findPaymentById(long id);
    Payments save(Payments payments);

}
