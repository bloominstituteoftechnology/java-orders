package com.stepasha.javaorders.services;

import com.stepasha.javaorders.models.Orders;
import com.stepasha.javaorders.repository.CustomersRepository;
import com.stepasha.javaorders.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Transactional

@Service(value = "orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderService orderService;
    @Autowired
    private CustomersRepository custRepo;

    @Autowired
    private OrdersRepository orderRepository;


    @Override
    public Orders getOrderById(long ordnum) {
        return orderRepository.findByOrdnum(ordnum);
    }

    @Override
    public List<Orders> findAll() {

        List<Orders> list = new ArrayList<>();
        orderRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
    @Transactional
    @Override
    public Orders save(Orders orders) {
    //     Customers newCustomer = new Customers();
        Orders newOrders = new Orders();
        newOrders.setOrdamount(orders.getOrdamount());
        newOrders.setAdvanceamount(orders.getAdvanceamount());
        newOrders.setCustomer(orders.getCustomer());
        newOrders.setOrderdescription(orders.getOrderdescription());

        return orderRepository.save(newOrders);
    }

    @Override
    public Orders update(Orders orders, long id) {
        Orders currentOrders = getOrderById(id);
        //if(customers.getCustname() != null) {
        if (orders.hasorderamount) {
            currentOrders.setOrdamount(orders.getOrdamount());
        }
        if (orders.hasadvanceammount) {
            currentOrders.setAdvanceamount(orders.getAdvanceamount());
        }
        if(orders.getCustomer() != null) {
            currentOrders.setCustomer(orders.getCustomer());
        }
        if (orders.getOrderdescription() != null) {
            currentOrders.setOrderdescription(orders.getOrderdescription());
        }
        return orderRepository.save(currentOrders);
    }
/*        // TODO 5
        if(findRestaurantById(id) != null){
            restrepos.deleteById(id);
        };*/
@Transactional
    @Override
    public void delete(long id) {
        if(getOrderById(id) != null){
            orderRepository.deleteById(id);
        }
    }
}
