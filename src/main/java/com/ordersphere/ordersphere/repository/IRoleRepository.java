package com.ordersphere.ordersphere.repository;

import com.ordersphere.ordersphere.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {

    boolean existsByRoleName(String roleName);
}
