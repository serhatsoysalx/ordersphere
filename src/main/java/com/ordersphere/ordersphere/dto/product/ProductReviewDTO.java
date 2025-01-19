package com.ordersphere.ordersphere.dto.product;

import com.ordersphere.ordersphere.entity.User;
import com.ordersphere.ordersphere.entity.product.Product;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductReviewDTO {

    private Long id;

    private Integer rating;

    private String reviewText;

    private LocalDateTime createdAt;

    private Product product;

    private User user;

    public ProductReviewDTO() {
    }

    public ProductReviewDTO(Long id, Integer rating, String reviewText, LocalDateTime createdAt, Product product, User user) {
        this.id = id;
        this.rating = rating;
        this.reviewText = reviewText;
        this.createdAt = createdAt;
        this.product = product;
        this.user = user;
    }
}
