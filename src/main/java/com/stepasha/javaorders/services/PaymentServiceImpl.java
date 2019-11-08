package com.stepasha.javaorders.services;

import com.stepasha.javaorders.models.Payments;
import com.stepasha.javaorders.repository.PaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Transactional
@Service(value = "paymentService")
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    PaymentsRepository payrepo;
    @Override
    public Payments findPaymentById(long id) {
        return payrepo.findById(id)
                .orElseThrow(() ->  new EntityNotFoundException("Payment not found"));
    }

    @Override
    public Payments save(Payments payments) {
        return null;
    }
}
