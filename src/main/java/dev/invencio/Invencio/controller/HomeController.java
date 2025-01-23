package dev.invencio.Invencio.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import dev.invencio.Invencio.mapper.StockMapper;
import dev.invencio.Invencio.dto.AdminResponse;
import dev.invencio.Invencio.model.Admin;
import dev.invencio.Invencio.model.CartItem;
import dev.invencio.Invencio.model.Stock;
import dev.invencio.Invencio.service.InvencioService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final InvencioService service;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        return "Dashboard/dash";
    }

    @GetMapping("/{id}")
    public String getAdminById(@PathVariable String id, Model model) {
        AdminResponse adminResponse = service.getAdminById(id);
        model.addAttribute("admin", adminResponse);
        return "Dashboard/dash";
    }

    @GetMapping("/addstock")
    public String addStock() {
        return "AddStock/addStock";
    }

    @PostMapping("/add-stock")
    public String addStock(@ModelAttribute Stock invencio) throws IOException {
        System.out.println(invencio);
        service.createNewStock(invencio);
        return "redirect:/addstock";
    }

    // view product

    @GetMapping("/viewstock")
    public String viewStock(@RequestParam(required = false) String searchTerm, Model model) {
        if (searchTerm == null) {
            List<Stock> stocks = service.getAllStocks();
            var stockResponse = stocks.stream().map(StockMapper::convertStockToResponse).toList();
            model.addAttribute("response", stockResponse);
            return "Product/product";
        } else {
            List<Stock> stocks = service.getStockBySearchTerm(searchTerm);
            var stockResponse = stocks.stream().map(StockMapper::convertStockToResponse).toList();
            model.addAttribute("response", stockResponse);
            model.addAttribute("searchTerm", searchTerm);
            return "Product/product";
        }

    }

    @PostMapping("/viewstock-search")
    public String viewAllSearch(@RequestParam String searchTerm) {
        if (searchTerm == null || searchTerm.isEmpty() || searchTerm.isBlank()) {
            return "redirect:/viewstock";
        } else {
            return "redirect:/viewstock" + "?searchTerm=" + searchTerm;
        }
    }

    @GetMapping("/low-stock")
    public String lowStock(Model model) {
        List<Stock> stocks = service.getLowStocks();
        var stockResponse = stocks.stream().map(StockMapper::convertStockToResponse).toList();
        model.addAttribute("response", stockResponse);
        return "Product/product";
    }

    @GetMapping("/update-stock")
    public String updateStock(@RequestParam String stockId, Model model) {
        var stocks = service.getStockById(stockId);
        model.addAttribute("stock", stocks);
        return "UpdateStock/update-product";
    }

    @PostMapping("/update-stock")
    public String updateStock(@ModelAttribute Stock stock, @RequestParam String stockId) {
        System.out.println(stockId);
        service.updateStock(stock, stockId);
        return "redirect:/viewstock";
    }

    @PostMapping("/update-stock-quantity")
    public ResponseEntity<String> updateStockQuantity(@RequestBody List<CartItem> cartItems) {
        try {
            // Attempt to update stock quantities
            service.updateStockQuantities(cartItems);
            return ResponseEntity.ok("Stock updated successfully!");
        } catch (RuntimeException e) {
            // Handle custom runtime exceptions (e.g., insufficient stock or stock not
            // found)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            // Handle general exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred. Please try again later.");
        }
    }

    @GetMapping("/delete-stock")
    public String deleteStock(@RequestParam String stockId) {
        service.deleteStock(stockId);
        return "redirect:/viewstock";
    }
    // add admin

    @GetMapping("/addadmin")
    public String addAdmin() {
        return "AddAdmin/add-admin";
    }

    @PostMapping("/add-admin")
    public String postMethodName(@ModelAttribute Admin admin) throws IOException {
        System.out.println(admin);
        service.createAdmin(admin);
        return "redirect:/dashboard";
    }

    @GetMapping("/getalladmin")
    public String getAllAdmin(Model model) {
        List<AdminResponse> adminList = service.getAllAdmin();
        model.addAttribute("adminList", adminList);
        return "ShowAdmin/show-admin";
    }

}
