package com.ordersphere.ordersphere.repository.product;

import com.ordersphere.ordersphere.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
}
