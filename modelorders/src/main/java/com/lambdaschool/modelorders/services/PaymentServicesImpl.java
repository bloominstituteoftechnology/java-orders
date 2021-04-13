package com.lambdaschool.modelorders.services;

import com.lambdaschool.modelorders.models.Payment;
import com.lambdaschool.modelorders.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class PaymentServicesImpl implements PaymentServices {

  @Autowired
  PaymentRepository paymentrepos;

  @Transactional
  @Override
  public Payment save(Payment payment) {
    return paymentrepos.save(payment);
  }
}
