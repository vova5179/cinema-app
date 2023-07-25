package org.example.service;

import org.example.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
