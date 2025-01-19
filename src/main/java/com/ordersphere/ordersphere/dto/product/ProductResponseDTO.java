package com.ordersphere.ordersphere.dto.product;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ProductResponseDTO {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private CategoryResponseDTO category;
    private BrandResponseDTO brand;
    private String sku;
    private String barcode;
    private BigDecimal weight;
    private String dimensions;
    private Boolean isActive;
    private String imageUrl;
    private List<ProductImageDTO> images;
    private List<StockDTO> stocks;
    private List<DiscountDTO> discounts;
    private List<ProductReviewDTO> reviews;
    private List<PriceHistoryDTO> priceHistories;

    public ProductResponseDTO() {
    }

    public ProductResponseDTO(Long id,
                              String name,
                              String description,
                              BigDecimal price,
                              CategoryResponseDTO category,
                              BrandResponseDTO brand,
                              String sku,
                              String barcode,
                              BigDecimal weight,
                              String dimensions,
                              Boolean isActive,
                              String imageUrl,
                              List<ProductImageDTO> images,
                              List<StockDTO> stocks,
                              List<DiscountDTO> discounts,
                              List<ProductReviewDTO> reviews,
                              List<PriceHistoryDTO> priceHistories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.brand = brand;
        this.sku = sku;
        this.barcode = barcode;
        this.weight = weight;
        this.dimensions = dimensions;
        this.isActive = isActive;
        this.imageUrl = imageUrl;
        this.images = images;
        this.stocks = stocks;
        this.discounts = discounts;
        this.reviews = reviews;
        this.priceHistories = priceHistories;
    }
}
