package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Payment;
import com.lambdaschool.javaorders.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Transactional
@Service(value = "paymentservices")
public class PaymentServicesImpl implements PaymentServices {

    @Autowired
    private PaymentRepository paymentRepository;


    @Transactional
    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save( payment);
    }


}
