package com.ordersphere.ordersphere.controller;

import com.ordersphere.ordersphere.dto.product.ProductRequestDTO;
import com.ordersphere.ordersphere.dto.product.ProductResponseDTO;
import com.ordersphere.ordersphere.service.product.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Product Controller to manage product-related endpoints.
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Endpoint to create a new product.
     *
     * @param productRequestDTO The product data to create.
     * @return The created product data.
     */
    @PostMapping("/create")
    public ResponseEntity<ProductResponseDTO> createProduct(@Valid @RequestBody ProductRequestDTO productRequestDTO) {
        try {
            ProductResponseDTO productResponseDTO = productService.createProduct(productRequestDTO);
            return new ResponseEntity<>(productResponseDTO, HttpStatus.CREATED); // 201 Created status
        } catch (Exception e) {
            return buildErrorResponse("Error while creating product: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Endpoint to get all products.
     *
     * @return List of all products.
     */
    @GetMapping("/getproductlist")
    public ResponseEntity<List<ProductResponseDTO>> getAllProductList() {
        List<ProductResponseDTO> productResponseDTOList = productService.getAllProductList();
        if (productResponseDTOList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content if list is empty
        }
        return new ResponseEntity<>(productResponseDTOList, HttpStatus.OK); // 200 OK with list of products
    }

    /**
     * Helper method to build a consistent error response with ProductResponseDTO.
     *
     * @param message The error message.
     * @param status  The HTTP status code.
     * @return The error response entity.
     */
    private ResponseEntity<ProductResponseDTO> buildErrorResponse(String message, HttpStatus status) {
        ProductResponseDTO errorResponse = new ProductResponseDTO();
        errorResponse.setName("Error");
        errorResponse.setDescription(message);
        return new ResponseEntity<>(errorResponse, status);
    }
}
