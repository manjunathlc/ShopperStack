package edu.org.ShopperStack1.controller;

import edu.org.ShopperStack1.entity.Product;
import edu.org.ShopperStack1.service.ProductService;
import edu.org.ShopperStack1.util.ResponseStructure;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @RequestMapping("/save")
    ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @RequestMapping("/get/{productId}")
    ResponseEntity<ResponseStructure<Product>> getProductById(@PathVariable Long productId){
        return productService.getProductById(productId);
    }

    @RequestMapping("/getAll")
    ResponseEntity<ResponseStructure<List<Product>>> getAllProducts(){
        return productService.getAllProducts();
    }




}
