package org.example.dao;

import java.util.List;
import org.example.model.Order;
import org.example.model.User;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
