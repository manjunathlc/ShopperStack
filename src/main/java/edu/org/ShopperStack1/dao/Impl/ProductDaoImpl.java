package edu.org.ShopperStack1.dao.Impl;

import edu.org.ShopperStack1.dao.ProductDao;
import edu.org.ShopperStack1.entity.Product;
import edu.org.ShopperStack1.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class ProductDaoImpl implements ProductDao {

    @Override
    public boolean isPresent(Long productId) {
        return productRepository.existsById(productId);
    }

    @Override
    public Product updateProductById(Long productId, Product updatedProduct) {
        return productRepository.save(updatedProduct);
    }


    private final ProductRepository productRepository;
    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> findById(Long productId) {
        return productRepository.findById(productId);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void deleteById(Long productId) {
        productRepository.deleteById(productId);
    }


}
