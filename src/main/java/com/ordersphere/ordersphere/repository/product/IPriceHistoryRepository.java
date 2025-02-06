package com.ordersphere.ordersphere.repository.product;

import com.ordersphere.ordersphere.entity.product.PriceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPriceHistoryRepository extends JpaRepository<PriceHistory, Long> {
}
