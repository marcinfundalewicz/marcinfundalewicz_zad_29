package pl.javastart.jjdind84.marcinfundalewicz.zad29.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model, @RequestParam(required = false) String message) {
        model.addAttribute("message", message);
        return "loginForm";
    }
}