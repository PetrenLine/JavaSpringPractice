package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.ProductDTO;
import org.example.entity.Product;
import org.example.mapper.ProductMapper;
import org.example.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product create(ProductDTO dto) {
        Product product = ProductMapper.INSTANCE.productDTOToProduct(dto);
        return productRepository.save(product);
    }

    public List<Product> readAll() {
        return productRepository.findAll();
    }

    public Product update(Product product) {
        return productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public Product readById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public List<Product> readInStockProducts() {
        return productRepository.findByInStockTrue();
    }
}
