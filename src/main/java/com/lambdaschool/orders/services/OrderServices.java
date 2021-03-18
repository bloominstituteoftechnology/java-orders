package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Order;

public interface OrderServices {
    Order findOrderByOrdnum(long ordnum);

    // post and put
    Order save(Order order);

    // delete
    void delete(long ordnum);


}
