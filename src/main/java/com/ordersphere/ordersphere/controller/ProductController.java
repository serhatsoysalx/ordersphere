package com.ordersphere.ordersphere.controller;


import com.ordersphere.ordersphere.dto.product.ProductRequestDTO;
import com.ordersphere.ordersphere.dto.product.ProductResponseDTO;
import com.ordersphere.ordersphere.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
//        try {
            final ProductResponseDTO productResponseDTO = productService.createProduct(productRequestDTO);
//            return new ResponseEntity<>(productResponseDTO, HttpStatus.OK);
//        } catch (Exception ex) {
//            return buildErrorResponse(productRequestDTO.getName(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
        return new ResponseEntity<>(productResponseDTO, HttpStatus.OK);
    }

    private ResponseEntity<String> buildErrorResponse(String message, HttpStatus status) {
        return new ResponseEntity<>(message, status);
    }
}
