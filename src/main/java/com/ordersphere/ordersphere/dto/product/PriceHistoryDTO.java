package com.ordersphere.ordersphere.dto.product;

import com.ordersphere.ordersphere.entity.product.Product;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class PriceHistoryDTO {

    private Long id;

    private BigDecimal oldPrice;

    private BigDecimal newPrice;

    private LocalDateTime changedAt;

    private Product product;

    public PriceHistoryDTO() {
    }

    public PriceHistoryDTO(Long id, BigDecimal oldPrice, BigDecimal newPrice, LocalDateTime changedAt, Product product) {
        this.id = id;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.changedAt = changedAt;
        this.product = product;
    }
}

