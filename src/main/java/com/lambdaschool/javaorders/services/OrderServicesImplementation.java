package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Order;
import com.lambdaschool.javaorders.models.Payment;
import com.lambdaschool.javaorders.repositories.OrdersRepository;
import com.lambdaschool.javaorders.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Transactional
@Service(value = "orderServices")
public class OrderServicesImplementation implements OrderServices{
    @Autowired
    OrdersRepository orderrepos;

    @Autowired
    PaymentRepository paymentrepos;

    @Override
    public Order findOrderById(long value) {
        return orderrepos.findById(value)
                .orElseThrow(() -> new EntityNotFoundException("Order " + value + " was not found"));
    }

    @Override
    public List<Order> getCustAdvanceAmt(double amount) {
        return orderrepos.findByAdvanceamountGreaterThan(amount);
    }

    @Transactional
    @Override
    public Order save(Order order) {
        Order newOrder = new Order();
        if(order.getOrdnum() != 0 )
        {
            findOrderById(order.getOrdnum());
            newOrder.setOrdnum((order.getOrdnum()));
        }
        newOrder.setAdvanceamount(order.getAdvanceamount());
        newOrder.setOrdamount(order.getOrdamount());
        newOrder.setOrderdescription(order.getOrderdescription());
        newOrder.setCustomer(order.getCustomer());

        newOrder.getPayments().clear();
        for(Payment p : order.getPayments())
        {
            Payment newPayment = paymentrepos.findById(p.getPaymentid())
                    .orElseThrow(() -> new EntityNotFoundException("Payment " + p.getPaymentid() + " not found!"));

            newOrder.getPayments().add(newPayment);
        }
        return orderrepos.save(newOrder);
    }

    @Transactional
    @Override
    public void delete(long ordernum) {
        if(orderrepos.findById(ordernum).isPresent())
        {
            orderrepos.deleteById(ordernum);
        } else {
            throw new EntityNotFoundException("Order " + ordernum + " not found!");
        }
    }
}
