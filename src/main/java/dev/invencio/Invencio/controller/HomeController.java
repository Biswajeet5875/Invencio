package dev.invencio.Invencio.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String dashboard() {
        return "Dashboard/dash";
    }

    @GetMapping("/new-stock")
    public String addStock() {
        return "AddStock/addStock";
    }

<<<<<<< HEAD
    @PostMapping("/addstock")
    public String addStock(@ModelAttribute Invencio invencio, @RequestParam int stockId) throws IOException {
=======
    @PostMapping("/add-stock")
    public String addStock(@ModelAttribute Stock invencio) throws IOException {
>>>>>>> 6307b9c55b51b0d1aae51700cc3ae0c71fb5472e
        System.out.println(invencio);
        service.createNewStock(invencio);
        return "redirect:/addstock";
    }
}
