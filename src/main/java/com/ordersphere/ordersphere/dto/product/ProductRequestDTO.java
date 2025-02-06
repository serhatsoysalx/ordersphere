package com.ordersphere.ordersphere.dto.product;

import java.math.BigDecimal;
import java.util.List;

public class ProductRequestDTO {

    private String name;
    private String description;
    private BigDecimal price;
    private Long categoryId;
    private Long brandId;
    private Boolean isActive;
    private BigDecimal weight;
    private String dimensions;
    private String sku;
    private String imageUrl;
    private String barcode;
    private List<Long> imageIds;
    private List<StockDTO> stocks;
    private List<DiscountDTO> discounts;
    private List<ProductReviewDTO> reviews;
    private List<PriceHistoryDTO> priceHistories;

    public ProductRequestDTO() {
    }

    public ProductRequestDTO(String name,
                             String description,
                             BigDecimal price,
                             Long categoryId,
                             Long brandId,
                             Boolean isActive,
                             BigDecimal weight,
                             String dimensions,
                             String sku,
                             String imageUrl,
                             String barcode,
                             List<Long> imageIds,
                             List<StockDTO> stocks,
                             List<DiscountDTO> discounts,
                             List<ProductReviewDTO> reviews,
                             List<PriceHistoryDTO> priceHistories) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
        this.brandId = brandId;
        this.isActive = isActive;
        this.weight = weight;
        this.dimensions = dimensions;
        this.sku = sku;
        this.imageUrl = imageUrl;
        this.barcode = barcode;
        this.imageIds = imageIds;
        this.stocks = stocks;
        this.discounts = discounts;
        this.reviews = reviews;
        this.priceHistories = priceHistories;
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
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

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public List<Long> getImageIds() {
        return imageIds;
    }

    public void setImageIds(List<Long> imageIds) {
        this.imageIds = imageIds;
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
