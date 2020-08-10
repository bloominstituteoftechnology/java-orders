package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Payment;

public interface PaymentServices
{
    Payment save(Payment payment); // create method called save, means other apps can create a payment type
}
