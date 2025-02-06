package com.ordersphere.ordersphere.dto.product;

public class StockDTO {

    private Long id;

    private Integer quantity;

    private String location;

    public StockDTO() {
    }

    public StockDTO(Long id, Integer quantity, String location) {
        this.id = id;
        this.quantity = quantity;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
