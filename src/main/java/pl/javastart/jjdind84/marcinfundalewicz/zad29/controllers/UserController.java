package pl.javastart.jjdind84.marcinfundalewicz.zad29.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.javastart.jjdind84.marcinfundalewicz.zad29.user.UserService;
import pl.javastart.jjdind84.marcinfundalewicz.zad29.user.UpdateUserDto;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/updateUser")
    public String showUpdateForm(Model model, @RequestParam(required = false) String message ) {
        model.addAttribute("user", userService.getUserToUpdate());
        model.addAttribute("message", message);
        return "updateForm";
    }

    @PostMapping("/updateUserData")
    public String updateData(RedirectAttributes redirectAttributes, UpdateUserDto userDto) {
        redirectAttributes.addAttribute("message", "Dane zmienione");
        userService.updateUserData(userDto);
        return "redirect:/updateUser";
    }

    @PostMapping("/updateUserPassword")
    public String updatePassword(@RequestParam String password, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("message", "Hasło zmienione");
        userService.updateUserPassword(password);
        return "redirect:/updateUser";
    }
}
