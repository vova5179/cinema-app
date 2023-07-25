package org.example.service;

import org.example.model.Role;

public interface RoleService {
    Role add(Role role);

    Role getByName(String roleName);
}
