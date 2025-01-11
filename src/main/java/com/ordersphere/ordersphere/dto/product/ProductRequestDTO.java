package com.ordersphere.ordersphere.dto.product;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ProductRequestDTO {

    private String name;               // Ürün adı
    private String description;        // Ürün açıklaması
    private BigDecimal price;          // Ürün fiyatı
    private Long categoryId;           // Kategori ID'si (yabancı anahtar)
    private Long brandId;              // Marka ID'si (yabancı anahtar)
    private Boolean isActive;          // Ürün aktif mi?
    private BigDecimal weight;         // Ürün ağırlığı
    private String dimensions;         // Ürün boyutları
    private String sku;                // Ürün SKU
    private String imageUrl;           // Ürün görseli
    private String barcode;            // Ürün barkodu
    private List<Long> imageIds;       // Ürün resimleri (imageId'ler)
    private List<StockDTO> stocks;     // Stok bilgileri
    private List<DiscountDTO> discounts; // İndirimler
    private List<ProductReviewDTO> reviews; // Ürün yorumları
    private List<PriceHistoryDTO> priceHistories; // Fiyat

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
}
