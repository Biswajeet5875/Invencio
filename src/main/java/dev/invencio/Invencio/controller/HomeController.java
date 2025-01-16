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
    public String dashboard() {
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
    public String viewStock() {
        return "Product/product";
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
        model.addAttribute("adminList", adminList); // Add the list to the model
        System.out.println(adminList); // Optional for debugging
        return "AddAdmin/show-admin"; // Ensure this is the correct Thymeleaf template path
    }

    @GetMapping("/{id}")
    public String getAdminById(@PathVariable String id, Model model) {
        AdminResponse adminResponse = service.getAdminById(id);

        // Add the admin response to the model
        model.addAttribute("admin", adminResponse);

        // Return the name of the Thymeleaf template
        return "Dashboard/dash";
    }

}
