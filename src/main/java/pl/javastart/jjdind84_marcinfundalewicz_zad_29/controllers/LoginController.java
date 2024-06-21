package pl.javastart.jjdind84_marcinfundalewicz_zad_29.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model) {
        Boolean registrationSuccess = (Boolean) model.asMap().get("registrationSuccess");
        if (registrationSuccess != null) {
            model.addAttribute("registrationSuccess", registrationSuccess);
        }
        return "loginForm";
    }
}