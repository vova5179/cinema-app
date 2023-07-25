package org.example.dao;

import java.util.Optional;
import org.example.model.Role;

public interface RoleDao {
    Role add(Role role);

    Optional<Role> getByName(String roleName);
}
