package com.ordersphere.ordersphere.dto.product;

import com.ordersphere.ordersphere.entity.product.Discount;
import com.ordersphere.ordersphere.entity.product.Product;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class DiscountDTO {

    private Long id;

    private Discount.DiscountType discountType;

    private BigDecimal discountValue;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Product product;

    public DiscountDTO() {
    }

    public DiscountDTO(Long id, Discount.DiscountType discountType, BigDecimal discountValue, LocalDateTime startDate, LocalDateTime endDate, Product product) {
        this.id = id;
        this.discountType = discountType;
        this.discountValue = discountValue;
        this.startDate = startDate;
        this.endDate = endDate;
        this.product = product;
    }
}
