package edu.org.ShopperStack1.controller;

import edu.org.ShopperStack1.entity.Product;
import edu.org.ShopperStack1.service.ProductService;
import edu.org.ShopperStack1.util.ResponseStructure;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/save")
    ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @GetMapping("/get/{productId}")
    ResponseEntity<ResponseStructure<Product>> getProductById(@PathVariable Long productId){
        return productService.getProductById(productId);
    }

    @GetMapping("/getAll")
    ResponseEntity<ResponseStructure<List<Product>>> getAllProducts(){
        return productService.getAllProducts();
    }

    @DeleteMapping("/delete/{productId}")
    ResponseEntity<ResponseStructure<String>> deleteProductById(@PathVariable Long productId){
        return productService.deleteProductById(productId);
    }

    @PutMapping("/update/{productId}")
    ResponseEntity<ResponseStructure<Product>> updateProductById(@PathVariable Long productId, @RequestBody Product product){
        return productService.updateProductById(productId, product);
    }

}
