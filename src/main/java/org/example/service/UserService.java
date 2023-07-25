package org.example.service;

import java.util.Optional;
import org.example.model.User;

public interface UserService {
    User add(User user);

    User get(Long id);

    Optional<User> findByEmail(String email);
}
