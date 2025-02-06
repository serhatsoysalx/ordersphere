package com.ordersphere.ordersphere.dto.product;

import com.ordersphere.ordersphere.entity.product.Category;

import java.util.List;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public List<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<Category> subCategories) {
        this.subCategories = subCategories;
    }
}
