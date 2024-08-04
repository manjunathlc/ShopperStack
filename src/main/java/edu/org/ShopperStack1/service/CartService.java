package edu.org.ShopperStack1.service;

import edu.org.ShopperStack1.entity.Cart;
import edu.org.ShopperStack1.util.ResponseStructure;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface CartService {

    ResponseEntity<ResponseStructure<Cart>> saveCart(Cart cart, Long productId);

    //ResponseEntity<ResponseStructure<Cart>> saveCart(Cart cart);

    ResponseEntity<ResponseStructure<Cart>> getCartById(Long id);

    ResponseEntity<ResponseStructure<List<Cart>>> getAllCarts();

    ResponseEntity<ResponseStructure<String>> deleteCartById(Long id);

    //ResponseEntity<ResponseStructure<Cart>> updateCartById(Long id, Cart updatedCart);

    ResponseEntity<ResponseStructure<Cart>> addProductToCart(Long cartId, List<Long> productIds);



}
