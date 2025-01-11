package com.ordersphere.ordersphere.dto.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandResponseDTO {

    private Long id;

    private String name;

    private String description;

    public BrandResponseDTO() {
    }

    public BrandResponseDTO(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
