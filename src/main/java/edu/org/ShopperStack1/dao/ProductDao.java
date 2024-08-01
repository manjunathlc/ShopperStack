package edu.org.ShopperStack1.dao;

import edu.org.ShopperStack1.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductDao {
    // CRUD operations
    Product saveProduct(Product product);

    Optional<Product> findById(Long productId);

    List<Product> findAll();


}
