package pl.coderslab.controller.pagesControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import pl.coderslab.dao.UserDao;
import pl.coderslab.dto.LoginDTO;
import pl.coderslab.dto.UserDTO;
import pl.coderslab.model.User;
import pl.coderslab.services.LoginService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {
private static final String LOGIN = "views/login";
private static final String LOGGED = "views/logged";

    @Autowired
    private LoginService loginService;
    @GetMapping("login")
    public String login(Model model) {
        model.addAttribute("loginForm", new User());
        return LOGIN;
    }

    @PostMapping("login")
    public String processLogin(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser,
                               @ModelAttribute("loginForm") @Valid LoginDTO form, BindingResult result,
                               HttpSession session) {
        if (loggedUser != null) {
            return "redirect:/";
        }
        if (result.hasErrors()) {
            return LOGIN;
        }
        boolean validCredentials = loginService.validate(form.getLogin(), form.getPassword());
        if (!validCredentials) {
            result.rejectValue("login", "errors.invalid", "Wprowadzono błędny login lub hasło");
            return LOGIN;
        }
        UserDTO user = loginService.login(form.getLogin());
        session.setAttribute("loggedUser", user);
        return LOGGED;
    }
}
