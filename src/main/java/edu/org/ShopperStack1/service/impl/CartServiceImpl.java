package edu.org.ShopperStack1.service.impl;

import edu.org.ShopperStack1.dao.CartDao;
import edu.org.ShopperStack1.dao.ProductDao;
import edu.org.ShopperStack1.entity.Cart;
import edu.org.ShopperStack1.entity.Product;
import edu.org.ShopperStack1.exception.CartNotFoundException;
import edu.org.ShopperStack1.service.CartService;
import edu.org.ShopperStack1.util.ResponseStructure;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartDao cartDao;

    private final ProductDao productDao;


    @Override
    public ResponseEntity<ResponseStructure<Cart>> saveCart(Cart cart, Long productId) {
        Optional<Product> productOptional = productDao.findById(productId);
        if (productOptional.isPresent()) {
            List<Product> listOfProducts = cart.getProducts();
            if (listOfProducts == null) {
                listOfProducts = new ArrayList<Product>() ;
            }
            listOfProducts.add(productOptional.get());
            cart.setProducts(listOfProducts);
            cart.setNumberOfProducts(cart.getProducts().size());
            double totalPrice = 0;
            for (Product product : cart.getProducts()) {
                totalPrice += product.getProductPrice().doubleValue();
            }
            cart.setTotalPrice(totalPrice);
            Cart savedCart = cartDao.saveCart(cart);
            ResponseStructure<Cart> structure = new ResponseStructure<>();
            structure.setData(savedCart);
            structure.setMessage("Cart saved successfully");
            return new ResponseEntity<ResponseStructure<Cart>>(structure, HttpStatus.CREATED);
        }
        throw new CartNotFoundException("Product not found with id: " + productId);
    }

    @Override
    public ResponseEntity<ResponseStructure<Cart>> getCartById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseStructure<List<Cart>>> getAllCarts() {
        return null;
    }

    @Override
    public ResponseEntity<ResponseStructure<String>> deleteCartById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseStructure<Cart>> addProductToCart(Long cartId, List<Long> productIds) {
        return null;
    }
}
