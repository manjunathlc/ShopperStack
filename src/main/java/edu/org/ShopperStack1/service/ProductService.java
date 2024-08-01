package edu.org.ShopperStack1.service;

import edu.org.ShopperStack1.entity.Product;
import edu.org.ShopperStack1.util.ResponseStructure;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    ResponseEntity<ResponseStructure<Product>> saveProduct(Product product);

    ResponseEntity<ResponseStructure<Product>> getProductById(Long productId);
}
