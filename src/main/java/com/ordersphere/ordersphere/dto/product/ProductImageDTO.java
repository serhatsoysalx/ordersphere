package com.ordersphere.ordersphere.dto.product;

import com.ordersphere.ordersphere.entity.product.Product;

public class ProductImageDTO {

    private Long id;

    private String imageUrl;

    private Boolean isPrimary;

    private Product product;

    public ProductImageDTO() {
    }

    public ProductImageDTO(Long id, String imageUrl, Boolean isPrimary, Product product) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.isPrimary = isPrimary;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getPrimary() {
        return isPrimary;
    }

    public void setPrimary(Boolean primary) {
        isPrimary = primary;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
