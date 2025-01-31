package dev.invencio.Invencio.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import dev.invencio.Invencio.model.CartItem;
import dev.invencio.Invencio.service.InvencioService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final InvencioService stockService;

    @PostMapping("/add-to-cart")
    public ResponseEntity<?> addToCart(@RequestParam String stockId, @RequestParam int quantity) {
        var stockResponce = stockService.getStockById(stockId);

        if (stockResponce == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Stock not found for ID: " + stockId);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("stockId", stockResponce.getStockId());
        response.put("stockName", stockResponce.getItemName());
        response.put("price", stockResponce.getPrice());
        response.put("category", stockResponce.getCategory());
        response.put("quantity", quantity);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/cart")
    public String viewCart(HttpSession session, Model model) {
        // Retrieve cart from session
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        model.addAttribute("cart", cart);
        return "CartPage/cart";
    }

    @PostMapping("/checkout")
    public String checkout(HttpSession session) {
        // Clear the cart after checkout
        session.removeAttribute("cart");
        return "redirect:/cart";
    }
}
