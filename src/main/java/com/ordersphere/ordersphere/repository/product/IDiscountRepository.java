package com.ordersphere.ordersphere.repository.product;

import com.ordersphere.ordersphere.entity.product.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDiscountRepository extends JpaRepository<Discount, Long> {
}
