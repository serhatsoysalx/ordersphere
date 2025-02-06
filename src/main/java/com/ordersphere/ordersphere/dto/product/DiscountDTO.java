package com.ordersphere.ordersphere.dto.product;

import com.ordersphere.ordersphere.entity.product.Discount;
import com.ordersphere.ordersphere.entity.product.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Discount.DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(Discount.DiscountType discountType) {
        this.discountType = discountType;
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(BigDecimal discountValue) {
        this.discountValue = discountValue;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
