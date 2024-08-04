package edu.org.ShopperStack1.dao;

import edu.org.ShopperStack1.entity.Cart;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartDao {
    // CRUD operations
    Cart saveCart(Cart cart);

    List<Cart> findAll();

    Optional<Cart> findById(int cartId);

    void delete(int cartId);

    boolean isPresent(int cartId);
}
