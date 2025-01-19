package com.ordersphere.ordersphere.dto.product;

import com.ordersphere.ordersphere.entity.product.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
