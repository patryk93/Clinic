package pl.coderslab.controller.pagesControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String getHomepage() {
        return "views/homePage";
    }
}

