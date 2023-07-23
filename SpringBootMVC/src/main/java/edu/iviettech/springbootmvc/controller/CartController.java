package edu.iviettech.springbootmvc.controller;

import edu.iviettech.springbootmvc.model.Cart;
import edu.iviettech.springbootmvc.model.Order;
import edu.iviettech.springbootmvc.model.OrderDetail;
import edu.iviettech.springbootmvc.model.Product;
import edu.iviettech.springbootmvc.repository.OrderRepository;
import edu.iviettech.springbootmvc.service.CartService;
import edu.iviettech.springbootmvc.service.OrderService;
import edu.iviettech.springbootmvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("shoppingCart")
public class CartController {
    @Autowired
    private Cart cart;

    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;

    @GetMapping("addToCart/{productId}")
    public String addToCart(@PathVariable("productId") Long productId){
        cart.addToCart(productService.getProductById(productId));
        return "redirect:/shoppingCart/viewCart";
    }
    @GetMapping("viewCart")
    public String viewCart(@ModelAttribute OrderDetail orderDetail,
                           Model model){
        model.addAttribute("items", cart.getListItems());
        return "cart/itemsCart";
    }
    @GetMapping("removeItem/{cartId}")
    public String viewCart(@PathVariable("cartId") int cartId,
                           @ModelAttribute OrderDetail orderDetail,
                           Model model){
        cart.removeItem(cartId);
        return "redirect:/shoppingCart/viewCart";
    }
    @GetMapping("checkOut")
    public String getFormCheckOut(@ModelAttribute Order order,Model model){
//        Order order = new Order();
//        order.setOrderDate(LocalDateTime.now());
        model.addAttribute("order",order);
        return "cart/checkOut";
    }
    @PostMapping("checkOut")
    public String checkOut(@ModelAttribute Order order, Model model){
        orderService.saveOrderWithOrderDetail(order,cart.getListItems());
//        List<Order> orders = orderService.getAllOrder();
        model.addAttribute("orders",orderService.getAllOrder());
        return "cart/listOrder";
    }
    @GetMapping("orderDetail/{orderId}")
    public String getOrderDetail(@PathVariable("orderId") Long orderId, Model model){
        List<OrderDetail> details = orderService.getOrderDetailByOrder(orderId);
        model.addAttribute("details", details);
        return "cart/orderDetails";
    }
}
