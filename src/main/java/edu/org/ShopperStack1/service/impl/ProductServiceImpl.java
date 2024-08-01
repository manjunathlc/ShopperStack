package edu.org.ShopperStack1.service.impl;

import edu.org.ShopperStack1.dao.ProductDao;
import edu.org.ShopperStack1.entity.Product;
import edu.org.ShopperStack1.exception.ProductNotFoundException;
import edu.org.ShopperStack1.service.ProductService;
import edu.org.ShopperStack1.util.ResponseStructure;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    // Implement Product Service methods here

    private final ProductDao productDao;

    @Override
    public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {

        Product savedProduct = productDao.saveProduct(product);
        ResponseStructure<Product> structure = new ResponseStructure<>();
        structure.setData(savedProduct);
        structure.setMessage("Product saved successfully");
        structure.setStatusCode(HttpStatus.OK.value());
        return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ResponseStructure<Product>> getProductById(Long productId) {
        //Product product = productDao.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found with product id = " + productId));
        Optional<Product> optional = productDao.findById(productId);
        if(optional.isPresent()){
            ResponseStructure<Product> structure = new ResponseStructure<>();
            structure.setData(optional.get());
            structure.setMessage("Product found successfully");
            structure.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.FOUND);
        }
        throw new ProductNotFoundException("Product not found with product id = " + productId);
    }

    @Override
    public ResponseEntity<ResponseStructure<List<Product>>> getAllProducts() {
        List<Product> products = productDao.findAll();
        if(!products.isEmpty()){
            ResponseStructure<List<Product>> structure = new ResponseStructure<>();
            structure.setData(products);
            structure.setMessage("All products found successfully");
            structure.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<ResponseStructure<List<Product>>>(structure, HttpStatus.OK);
        }
        return new ResponseEntity<ResponseStructure<List<Product>>>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<ResponseStructure<String>> deleteProductById(Long productId) {
        if(productDao.findById(productId).isPresent()){
            productDao.deleteById(productId);
            ResponseStructure<String> structure = new ResponseStructure<>();
            structure.setData("Product deleted successfully");
            structure.setMessage("Product deleted successfully");
            structure.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
        }
        throw new ProductNotFoundException("Product not found with product id = " + productId);
    }


}
