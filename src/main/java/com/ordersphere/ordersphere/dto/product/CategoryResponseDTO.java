package com.ordersphere.ordersphere.dto.product;

import com.ordersphere.ordersphere.entity.product.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryResponseDTO {

    private Long id;

    private String name;

    private String description;

    private Category parentCategory;

    private List<Category> subCategories;

    public CategoryResponseDTO() {
    }

    public CategoryResponseDTO(Long id, String name, String description, Category parentCategory, List<Category> subCategories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.parentCategory = parentCategory;
        this.subCategories = subCategories;
    }
}
