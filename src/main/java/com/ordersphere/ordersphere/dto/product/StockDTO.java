package com.ordersphere.ordersphere.dto.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
