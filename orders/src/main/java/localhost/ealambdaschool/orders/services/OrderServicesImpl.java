package localhost.ealambdaschool.orders.services;

import localhost.ealambdaschool.orders.models.Order;
import localhost.ealambdaschool.orders.repo.OrderRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service(value = "orderService")
public class OrderServicesImpl implements OrderServices
{
    @Autowired
    OrderRepositories orderrepos;

    @Transactional
    @Override
    public Order save(Order order)
    {
        return orderrepos.save(order);
    }

}