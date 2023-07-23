package edu.iviettech.springbootmvc.model;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Data
public class Cart {
    private List<OrderDetail> listItems = new ArrayList<>();

    public void addToCart(Product product) {
        listItems.stream()
                .filter(item -> item.getProduct().getId() == product.getId())
                .findFirst()
                .ifPresentOrElse(item -> item.setQuantity(item.getQuantity() + 1),
                        () -> {
                            OrderDetail newItem = new OrderDetail();
                            newItem.setQuantity(1);
                            newItem.setProduct(product);
                            listItems.add(newItem);
                        }
                );
    }

    public void removeItem(int cartId) {
        listItems.remove(cartId);
    }

    public void emptyCart() {
        listItems.clear();
    }

    public Integer count() {
        return listItems.size();
    }

    public boolean checkExist(Product product) {
        return listItems.stream()
                .anyMatch(item -> item.getProduct().getId() == product.getId());
    }
}
