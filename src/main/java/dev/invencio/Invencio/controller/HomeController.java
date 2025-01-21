package dev.invencio.Invencio.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.invencio.Invencio.mapper.StockMapper;
import dev.invencio.Invencio.dto.AdminResponse;
import dev.invencio.Invencio.model.Admin;
import dev.invencio.Invencio.model.Stock;
import dev.invencio.Invencio.service.InvencioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

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
    public String viewStock(Model model) {
        List<Stock> stocks = service.getAllStocks();
        var stockResponse = stocks.stream().map(StockMapper::convertStockToResponse).toList();
        model.addAttribute("response", stockResponse);
        return "Product/product";
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
    public String putMethodName(@ModelAttribute Stock stock, @RequestParam String stockId) {
        System.out.println(stockId);
        service.updateStock(stock, stockId);
        return "redirect:/viewstock";
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

    @GetMapping("/{id}")
    public String getAdminById(@PathVariable String id, Model model) {
        AdminResponse adminResponse = service.getAdminById(id);
        model.addAttribute("admin", adminResponse);
        return "Dashboard/dash";
    }

}
