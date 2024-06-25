package pl.javastart.jjdind84.marcinfundalewicz.zad29.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.javastart.jjdind84.marcinfundalewicz.zad29.user.UserService;
import pl.javastart.jjdind84.marcinfundalewicz.zad29.register.RegisterUserDto;

@Controller
public class RegisterController {
    private UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new RegisterUserDto());
        return "registerForm";
    }

    @PostMapping("/register")
    public String registerUser(RegisterUserDto registerUserDto, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("message", "Pomyślnie utworzono konto");
        userService.registerUser(registerUserDto);
        return "redirect:/login";
    }
}