package com.ordersphere.ordersphere.repository;

import com.ordersphere.ordersphere.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = :username AND u.passwordHash = :passwordHash")
    Optional<User> findByUsernameAndPasswordHash(String username, String passwordHash);

    Optional<User> findByUsername(String username);


}
