package org.example.config;

import java.util.Set;
import javax.annotation.PostConstruct;
import org.example.model.Role;
import org.example.model.User;
import org.example.service.RoleService;
import org.example.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;

    public DataInitializer(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void inject() {
        Role adminRole = new Role();
        adminRole.setRoleName(Role.RoleName.ADMIN);
        roleService.add(adminRole);
        Role userRole = new Role();
        userRole.setRoleName(Role.RoleName.USER);
        roleService.add(userRole);

        User admin = new User();
        admin.setEmail("admin@gmail.com");
        admin.setPassword("admin");
        admin.setRoles(Set.of(adminRole));
        userService.add(admin);

        User user = new User();
        user.setEmail("bob@gmail.com");
        user.setPassword("12345");
        user.setRoles(Set.of(userRole));
        userService.add(user);
    }
}

