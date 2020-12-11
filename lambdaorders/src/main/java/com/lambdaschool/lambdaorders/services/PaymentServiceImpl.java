package com.lambdaschool.lambdaorders.services;

import com.lambdaschool.lambdaorders.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service(value = "paymentService")
public class PaymentServiceImpl implements PaymentService
{
    @Autowired
    PaymentRepository paymentrepos;
}
