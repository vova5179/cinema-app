package org.example.service;

import org.example.model.MovieSession;
import org.example.model.ShoppingCart;
import org.example.model.User;

public interface ShoppingCartService {
    void addSession(MovieSession movieSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
