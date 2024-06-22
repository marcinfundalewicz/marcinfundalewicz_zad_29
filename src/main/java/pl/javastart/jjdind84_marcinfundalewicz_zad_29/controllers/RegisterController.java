package pl.javastart.jjdind84_marcinfundalewicz_zad_29.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.javastart.jjdind84_marcinfundalewicz_zad_29.register.RegisterUserDto;
import pl.javastart.jjdind84_marcinfundalewicz_zad_29.user.UserService;

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
        userService.registerUser(registerUserDto);
        boolean registrationSuccess = true;
        redirectAttributes.addFlashAttribute("registrationSuccess", registrationSuccess);
        return "redirect:/login";
    }
}