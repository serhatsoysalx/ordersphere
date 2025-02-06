package com.ordersphere.ordersphere.dto.product;

import com.ordersphere.ordersphere.entity.User;
import com.ordersphere.ordersphere.entity.product.Product;

import java.time.LocalDateTime;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
