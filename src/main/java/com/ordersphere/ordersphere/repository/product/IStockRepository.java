package com.ordersphere.ordersphere.repository.product;

import com.ordersphere.ordersphere.entity.product.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStockRepository extends JpaRepository<Stock, Long> {
}
