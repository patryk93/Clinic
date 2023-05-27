package pl.coderslab.controller.pagesControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class HomeController {

    private static final String HOME = "views/home";
    private static final String LOGGED = "views/logged";
    @RequestMapping("/")
    public String getHomepage() {
        return HOME;
    }

    @RequestMapping("/logged")
    public String getHomepageLogged() {
        return LOGGED;
    }
}

