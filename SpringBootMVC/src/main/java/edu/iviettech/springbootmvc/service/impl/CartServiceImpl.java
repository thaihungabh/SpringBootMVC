package edu.iviettech.springbootmvc.service.impl;

import edu.iviettech.springbootmvc.model.Cart;
import edu.iviettech.springbootmvc.model.OrderDetail;
import edu.iviettech.springbootmvc.model.Product;
import edu.iviettech.springbootmvc.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
//    @Autowired
//    Cart cart;
//
//    @Override
//    public void addToCart(Product product) {
//        cart.getListItems().stream()
//                .filter(item -> item.getProductId() == product.getId())
//                .findFirst()
//                .ifPresentOrElse(item -> item.setQuantity(item.getQuantity() + 1),
//                        () -> {
//                            OrderDetail newItem = new OrderDetail();
//                            newItem.setQuantity(1);
//                            newItem.setProductId(product.getId());
//                            cart.getListItems().add(newItem);
//                        }
//                );
//    }
//
//    @Override
//    public void removeItem(Product product) {
//        OrderDetail itemRemove = cart.getListItems().stream()
//                .filter(item -> item.getProductId()== product.getId())
//                .findAny()
//                .orElse(null);
//        cart.getListItems().remove(itemRemove);
//    }
//
//    @Override
//    public void emptyCart() {
//        cart.getListItems().clear();
//    }
//
//    @Override
//    public Integer count() {
//        return cart.getListItems().size();
//    }
//
//    @Override
//    public boolean checkExist(Product product) {
//        return cart.getListItems().stream()
//                .anyMatch(item -> item.getProductId() == product.getId());
//    }
}
