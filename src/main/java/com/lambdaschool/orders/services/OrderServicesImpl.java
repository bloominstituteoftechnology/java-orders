package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Order;
import com.lambdaschool.orders.models.Payment;
import com.lambdaschool.orders.repositories.OrdersRepository;
import com.lambdaschool.orders.repositories.PaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Transactional
@Service(value = "orderService")
public class OrderServicesImpl implements OrderServices{
    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private PaymentsRepository paymentsRepository;

    @Override
    public Order findOrderByOrdnum(long ordnum){
        Order order = ordersRepository.findOrderByOrdnum(ordnum);
        return order;
    }

    @Transactional
    @Override
    public Order save(Order order) {
        Order newOrder = new Order();

        if(order.getOrdnum() != 0){
            ordersRepository.findById(order.getOrdnum())
                    .orElseThrow(()->new EntityNotFoundException("Order "+order.getOrdnum()+" not found."));
            newOrder.setOrdnum(order.getOrdnum());
        }

        newOrder.setAdvanceamount(order.getAdvanceamount());
        newOrder.setOrdamount(order.getOrdamount());
        newOrder.setOrderdescription(order.getOrderdescription());
        newOrder.setCustomer(order.getCustomer());

        //manytomany
        newOrder.getPayments().clear();
        for(Payment p : order.getPayments()){
            Payment newPayment = paymentsRepository.findById(p.getPaymentid())
                    .orElseThrow(()->new EntityNotFoundException("Payment " + p.getPaymentid() + " not found."));
            newOrder.getPayments().add(newPayment);
        }
        return ordersRepository.save(newOrder);
    }

    @Override
    public void delete(long ordnum) {
        ordersRepository.findById(ordnum)
                .orElseThrow(()-> new EntityNotFoundException("Order "+ordnum+" not found."));
        ordersRepository.deleteById(ordnum);
    }

}
