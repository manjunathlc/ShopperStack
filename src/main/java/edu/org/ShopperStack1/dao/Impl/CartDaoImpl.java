package edu.org.ShopperStack1.dao.Impl;

import edu.org.ShopperStack1.dao.CartDao;
import edu.org.ShopperStack1.entity.Cart;
import edu.org.ShopperStack1.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CartDaoImpl implements CartDao {

    private final CartRepository cartRepository;
    @Override
    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public List<Cart> findAll() {
        return List.of();
    }

    @Override
    public Optional<Cart> findById(int cartId) {
        return Optional.empty();
    }

    @Override
    public void delete(int cartId) {

    }

    @Override
    public boolean isPresent(int cartId) {
        return false;
    }
}
