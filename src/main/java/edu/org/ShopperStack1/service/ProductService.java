package edu.org.ShopperStack1.service;

import edu.org.ShopperStack1.dao.ProductDao;
import edu.org.ShopperStack1.entity.Product;
import edu.org.ShopperStack1.util.ResponseStructure;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    // Implement Product Service methods here

    private final ProductDao productDao;

    public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {

        Product savedProduct = productDao.saveProduct(product);
        ResponseStructure<Product> structure = new ResponseStructure<>();
        structure.setData(savedProduct);
        structure.setMessage("Product saved successfully");
        structure.setStatusCode(HttpStatus.OK.value());
        return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.CREATED);
    }


}
