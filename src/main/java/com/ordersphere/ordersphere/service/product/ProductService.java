package com.ordersphere.ordersphere.service.product;

import com.ordersphere.ordersphere.dto.product.ProductRequestDTO;
import com.ordersphere.ordersphere.dto.product.ProductResponseDTO;
import com.ordersphere.ordersphere.entity.product.*;
import com.ordersphere.ordersphere.general.GeneralService;
import com.ordersphere.ordersphere.repository.product.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductService extends GeneralService<IProductRepository> {

    @Autowired
    private IStockRepository stockRepository;
    @Autowired
    private IDiscountRepository discountRepository;
    @Autowired
    private IProductReviewRepository productReviewRepository;
    @Autowired
    private IPriceHistoryRepository priceHistoryRepository;
    @Autowired
    private ICategoryRepository categoryRepository;
    @Autowired
    private IBrandRepository brandRepository;

    @Transactional
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        if (Objects.isNull(productRequestDTO)) {
            return null;
        }

        Product product = modelMapper.map(productRequestDTO, Product.class);

        Category category = categoryRepository.findById(productRequestDTO.getCategoryId()).orElse(null);
        Brand brand = brandRepository.findById(productRequestDTO.getBrandId()).orElse(null);

        if (category != null) {
            product.setCategory(category);
        }
        if (brand != null) {
            product.setBrand(brand);
        }

        final Product savedProduct = repository.save(product);

        if (productRequestDTO.getStocks() != null) {
            final List<Stock> stocks = productRequestDTO.getStocks().stream()
                    .map(stockDTO -> {
                        Stock stock = modelMapper.map(stockDTO, Stock.class);
                        stock.setProduct(savedProduct);
                        return stock;
                    })
                    .collect(Collectors.toList());
            stockRepository.saveAll(stocks);
        }

        if (productRequestDTO.getDiscounts() != null) {
            final List<Discount> discounts = productRequestDTO.getDiscounts().stream()
                    .map(discountDTO -> {
                        Discount discount = modelMapper.map(discountDTO, Discount.class);
                        discount.setProduct(savedProduct);
                        return discount;
                    })
                    .collect(Collectors.toList());
            discountRepository.saveAll(discounts);
        }

        if (productRequestDTO.getReviews() != null) {
            final List<ProductReview> reviews = productRequestDTO.getReviews().stream()
                    .map(reviewDTO -> {
                        ProductReview review = modelMapper.map(reviewDTO, ProductReview.class);
                        review.setProduct(savedProduct);
                        return review;
                    })
                    .collect(Collectors.toList());
            productReviewRepository.saveAll(reviews);
        }

        if (productRequestDTO.getPriceHistories() != null) {
            final List<PriceHistory> priceHistories = productRequestDTO.getPriceHistories().stream()
                    .map(priceHistoryDTO -> {
                        PriceHistory priceHistory = modelMapper.map(priceHistoryDTO, PriceHistory.class);
                        priceHistory.setProduct(savedProduct);
                        return priceHistory;
                    })
                    .collect(Collectors.toList());
            priceHistoryRepository.saveAll(priceHistories);
        }

        return modelMapper.map(savedProduct, ProductResponseDTO.class);
    }

    public List<ProductResponseDTO> getAllProductList() {
        List<ProductResponseDTO> responseDTOList =
                repository.findAll().stream().map(
                        product -> modelMapper.map(product, ProductResponseDTO.class)
                ).collect(Collectors.toList());
        return responseDTOList;
    }
}
