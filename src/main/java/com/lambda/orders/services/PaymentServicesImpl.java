package com.lambda.orders.services;

import com.lambda.orders.models.Payment;
import com.lambda.orders.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "restaurantService")
public class PaymentServicesImpl implements PaymentServices
{
    @Autowired
    PaymentRepository payrepos;

    @Transactional
    @Override
    public Payment save (Payment payment)
    {
        return payrepos.save(payment);
    }
}
