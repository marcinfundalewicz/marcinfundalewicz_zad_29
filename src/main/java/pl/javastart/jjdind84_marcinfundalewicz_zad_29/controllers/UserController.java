package pl.javastart.jjdind84_marcinfundalewicz_zad_29.controllers;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.javastart.jjdind84_marcinfundalewicz_zad_29.user.UpdateUserDto;
import pl.javastart.jjdind84_marcinfundalewicz_zad_29.user.UserService;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/updateUser")
    public String showUpdateForm(Model model) {
        model.addAttribute("user", userService.getUserToUpdate());
        return "updateForm";
    }

    @PostMapping("/updateUserData")
    public String updateData(Model model, UpdateUserDto userDto) {
        model.addAttribute("message", "Dane zmienione");
        userService.updateUserData(userDto);
        return "index";
    }

    @PostMapping("/updateUserPassword")
    public String updatePassword(@RequestParam String password, Model model) {
        model.addAttribute("message", "Hasło zmienione");
        userService.updateUserPassword(password);
        return "index";
    }
}
