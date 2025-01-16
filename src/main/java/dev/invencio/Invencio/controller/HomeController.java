package dev.invencio.Invencio.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

import dev.invencio.Invencio.model.Invencio;
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

<<<<<<< HEAD
    @GetMapping("/new-stock")
=======
    @GetMapping("/addstock")
>>>>>>> 29eef433c8cfbce339d20f77e4ee4dc0ae536ae3
    public String addStock() {
        return "AddStock/addStock";
    }

<<<<<<< HEAD
    @PostMapping("/addstock")
    public String addStock(@ModelAttribute Invencio invencio, @RequestParam int stockId) throws IOException {
=======
    @PostMapping("/add-stock")
    public String addStock(@ModelAttribute Invencio invencio) throws IOException {
>>>>>>> 29eef433c8cfbce339d20f77e4ee4dc0ae536ae3
        System.out.println(invencio);
        service.createNewStock(invencio);
        return "redirect:/addstock";
    }
}
