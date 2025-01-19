package com.ordersphere.ordersphere.service.product;

import com.ordersphere.ordersphere.dto.product.ProductRequestDTO;
import com.ordersphere.ordersphere.dto.product.ProductResponseDTO;
import com.ordersphere.ordersphere.general.GeneralService;
import com.ordersphere.ordersphere.repository.product.IProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends GeneralService<IProductRepository> {

    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {



        return new ProductResponseDTO();
    }
}
