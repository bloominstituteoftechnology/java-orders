package com.lambdaschool.lambdaorders.services;

import com.lambdaschool.lambdaorders.models.Order;
import com.lambdaschool.lambdaorders.models.Payment;
import com.lambdaschool.lambdaorders.repositories.OrderRepository;
import com.lambdaschool.lambdaorders.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service(value = "orderService")
public class OrderServiceImpl implements OrderService
{
    @Autowired
    private OrderRepository orderrepos;

    @Autowired
    PaymentRepository paymentrepos;

    @Override
    public List<Order> findOrdersWithAdvanceAmount()
    {
        return orderrepos.findAllByAdvanceamountGreaterThan(0.00);

    }

    @Override
    public Order findOrderById(long ordnum) throws EntityNotFoundException
    {
        return orderrepos.findById(ordnum).orElseThrow(() -> new EntityNotFoundException("Order " + ordnum + " Not Found"));
    }

    @Transactional
    @Override
    public Order save(Order order)
    {
        Order newOrder = new Order();

        if(order.getOrdnum() != 0)
        {
            orderrepos.findById(order.getOrdnum()).orElseThrow(()-> new EntityNotFoundException("Order " + order.getOrdnum() + " Not Found"));
            newOrder.setOrdnum(order.getOrdnum());
        }

        newOrder.setOrdamount(order.getOrdamount());
        newOrder.setAdvanceamount(order.getAdvanceamount());
        newOrder.setOrderdescription(order.getOrderdescription());

        newOrder.getPayments().clear();
        for(Payment p : order.getPayments())
        {
            Payment newPayment = paymentrepos.findById(p.getPaymentid()).orElseThrow(()-> new EntityNotFoundException("Payment " + p.getPaymentid() + " Not Found"));
            newOrder.getPayments().add(newPayment);
        }

        return orderrepos.save(newOrder);
    }

    @Transactional
    @Override
    public Order update(Order order, long ordnum)
    {
        Order updateOrder = orderrepos.findById(ordnum).orElseThrow(()-> new EntityNotFoundException("Order " + ordnum + " Not Found"));
        if(order.getOrdamount() != 0.00)
        {
            updateOrder.setOrdamount(order.getOrdamount());
        }

        if(order.getOrderdescription() != null)
        {
            updateOrder.setOrderdescription(order.getOrderdescription());
        }

        if(order.getAdvanceamount() != 0.00)
        {
            updateOrder.setAdvanceamount(order.getAdvanceamount());
        }

        if(order.getPayments().size() > 0)
        {
            for (Payment p : order.getPayments())
            {
                Payment newPayment = paymentrepos.findById(p.getPaymentid()).orElseThrow(()-> new EntityNotFoundException("Payment " + p.getPaymentid() + " Not Found"));
                updateOrder.getPayments().add(newPayment);
            }
        }
        return orderrepos.save(updateOrder);
    }

    @Transactional
    @Override
    public void delete(long ordnum)
    {
        orderrepos.deleteById(ordnum);
    }

    @Transactional
    @Override
    public void deleteAll()
    {
        orderrepos.deleteAll();
    }

}
