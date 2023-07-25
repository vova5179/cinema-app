package org.example.service;

import java.util.List;
import org.example.model.Order;
import org.example.model.ShoppingCart;
import org.example.model.User;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
