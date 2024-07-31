package edu.org.ShopperStack1.dao;

import edu.org.ShopperStack1.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao {
    // CRUD operations
    Product saveProduct(Product product);
}
