package com.aldair.orders.services;

import com.aldair.orders.models.Payment;
import com.aldair.orders.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "paymentService")
public class PaymentServiceImp implements PaymentService{
    @Autowired
    PaymentRepository paymentrepo;

    @Override
    public Payment save(Payment payment) {
        return paymentrepo.save(payment);
    }
}
