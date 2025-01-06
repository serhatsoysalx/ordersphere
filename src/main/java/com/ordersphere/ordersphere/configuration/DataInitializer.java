package com.ordersphere.ordersphere.configuration;

import com.ordersphere.ordersphere.entity.Role;
import com.ordersphere.ordersphere.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        if (!roleRepository.existsByRoleName("ADMIN")) {
            Role role = new Role();
            role.setStatus(Boolean.TRUE);
            role.setRoleName("ADMIN");
            roleRepository.save(role);
        }

        if (!roleRepository.existsByRoleName("USER")) {
            Role role = new Role();
            role.setStatus(Boolean.TRUE);
            role.setRoleName("USER");
            roleRepository.save(role);
        }
    }
}
