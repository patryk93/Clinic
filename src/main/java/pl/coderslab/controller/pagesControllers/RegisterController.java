package pl.coderslab.controller.pagesControllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.UserDao;
import pl.coderslab.dto.RegisterDTO;
import pl.coderslab.model.User;
import pl.coderslab.services.RegisterService;

import javax.validation.Valid;
import java.awt.print.Book;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController {

    @Autowired
    private final UserDao userDao;

    @Autowired
    private RegisterService registerService;
    private static final String REGISTER = "views/register";
    private static final String LOGGED = "views/logged";

    @GetMapping("add")
    public String showRegistrationPage(Model model) {
        model.addAttribute("registerForm", new User());
        return REGISTER;
    }

    @PostMapping("add")
    public String processRegistrationForm(@ModelAttribute("registerForm") @Valid RegisterDTO form,
                                          BindingResult results, Model model) {
        if (results.hasErrors()) {
            return REGISTER;
        }
        if (!form.getConfirmedPassword().equals(form.getPassword())) {
            results.rejectValue("password","errors.notmatch","Podane hasła różnią się od siebie");
            return REGISTER;
        }
        try {
            registerService.register(form);
            return LOGGED;
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
            results.rejectValue("login", "errors.nonunique", "Login lub E-mail już istnieje");
            return REGISTER;
        } catch (RuntimeException re) {
            re.printStackTrace();
            model.addAttribute("error", true);
            return REGISTER;
        }
    }


}
