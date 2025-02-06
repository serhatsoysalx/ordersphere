package com.ordersphere.ordersphere.dto.product;

import java.math.BigDecimal;
import java.util.List;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CategoryResponseDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryResponseDTO category) {
        this.category = category;
    }

    public BrandResponseDTO getBrand() {
        return brand;
    }

    public void setBrand(BrandResponseDTO brand) {
        this.brand = brand;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<ProductImageDTO> getImages() {
        return images;
    }

    public void setImages(List<ProductImageDTO> images) {
        this.images = images;
    }

    public List<StockDTO> getStocks() {
        return stocks;
    }

    public void setStocks(List<StockDTO> stocks) {
        this.stocks = stocks;
    }

    public List<DiscountDTO> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<DiscountDTO> discounts) {
        this.discounts = discounts;
    }

    public List<ProductReviewDTO> getReviews() {
        return reviews;
    }

    public void setReviews(List<ProductReviewDTO> reviews) {
        this.reviews = reviews;
    }

    public List<PriceHistoryDTO> getPriceHistories() {
        return priceHistories;
    }

    public void setPriceHistories(List<PriceHistoryDTO> priceHistories) {
        this.priceHistories = priceHistories;
    }
}
