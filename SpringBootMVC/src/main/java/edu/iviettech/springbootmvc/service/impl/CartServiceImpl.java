package edu.iviettech.springbootmvc.service.impl;

import edu.iviettech.springbootmvc.model.Cart;
import edu.iviettech.springbootmvc.model.OrderDetail;
import edu.iviettech.springbootmvc.model.Product;
import edu.iviettech.springbootmvc.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    Cart cart;

    @Override
    public List<OrderDetail> getShoppingCart() {
        return cart.getListItems();
    }

    @Override
    public void addToCart(Product product) {
        cart.getListItems().stream()
                .filter(item -> item.getProduct().getId() == product.getId())
                .findFirst()
                .ifPresentOrElse(item -> item.setQuantity(item.getQuantity() + 1),
                        () -> {
                            OrderDetail newItem = new OrderDetail();
                            newItem.setQuantity(1);
                            newItem.setProduct(product);
                            cart.getListItems().add(newItem);
                        }
                );
    }

    @Override
    public void removeItem(int cartId) {
        cart.getListItems().remove(cartId);
    }

    @Override
    public void emptyCart() {
        cart.getListItems().clear();
    }

    @Override
    public Integer count() {
        return cart.getListItems().size();
    }

    @Override
    public boolean checkExist(Product product) {
        return cart.getListItems().stream()
                .anyMatch(item -> item.getProduct().getId() == product.getId());
    }
}
