package com.ordersphere.ordersphere.repository;

import com.ordersphere.ordersphere.entity.UserRules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRulesRepository extends JpaRepository<UserRules, Long> {
}
