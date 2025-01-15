package dev.invencio.Invencio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String Home() {
        return "index";
    }

    @GetMapping("/dashboard")
    public String Dashboard() {
        return "Dashboard/dash";
    }

}
