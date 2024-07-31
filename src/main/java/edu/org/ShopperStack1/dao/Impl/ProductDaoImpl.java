package edu.org.ShopperStack1.dao.Impl;

import edu.org.ShopperStack1.dao.ProductDao;
import edu.org.ShopperStack1.entity.Product;
import edu.org.ShopperStack1.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ProductDaoImpl implements ProductDao {

    private final ProductRepository productRepository;
    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
