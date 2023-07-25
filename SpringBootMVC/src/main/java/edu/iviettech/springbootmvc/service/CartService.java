package edu.iviettech.springbootmvc.service;

import edu.iviettech.springbootmvc.model.OrderDetail;
import edu.iviettech.springbootmvc.model.Product;

import java.util.List;

public interface CartService {
    List<OrderDetail> getShoppingCart();
    void addToCart(Product product);
    void removeItem(int cartId);
    void emptyCart();
    Integer count();
    boolean checkExist(Product product);
}
