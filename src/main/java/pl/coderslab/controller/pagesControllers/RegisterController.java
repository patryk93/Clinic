package pl.coderslab.controller.pagesControllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.UserDao;
import pl.coderslab.model.User;

import javax.validation.Valid;
import java.awt.print.Book;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController {

    private final UserDao userDao;
    private static final String REGISTER = "views/register";

    @GetMapping("add")
    public String showRegistrationPage(Model model) {
        model.addAttribute("registerForm", new User());
        return REGISTER;
    }

    @PostMapping("add")
    public String saveNewBook(@ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return REGISTER;
        }
        if (user.getId() != null) {
            userDao.edit(user);
        } else {
            userDao.save(user);
        }
        return "redirect:/";
    }


}
