package localhost.ealambdaschool.orders.services;

import localhost.ealambdaschool.orders.models.Payment;
import localhost.ealambdaschool.orders.repo.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Transactional
@Service(value = "paymentService")
public class PaymentServicesImpl implements PaymentServices
{
    @Autowired
    private PaymentRepository paymentrepos;

    @Transactional
    @Override
    public Payment save(Payment payment)
    {
        return paymentrepos.save(payment);
    }
}