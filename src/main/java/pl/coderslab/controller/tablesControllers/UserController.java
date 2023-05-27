package pl.coderslab.controller.tablesControllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.UserDao;
import pl.coderslab.model.User;
import pl.coderslab.services.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    HttpSession session;
    @Autowired
    UserService userService;
    private final UserDao userDao;
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }
    @RequestMapping("/add")
    @ResponseBody
    public String hello() {
        User user = new User();
        user.setLogin("bruce72");
        user.setFirstName("Bruce");
        user.setLastName("Eckel");
        userDao.save(user);
        return "Id dodanego użytkownika to:"
                + user.getId();
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String get(@PathVariable long id) {
        User user = userDao.findById(id);
        return user.toString();
    }

    @RequestMapping("/update/{id}/{firstName}/{lastName}")
    @ResponseBody
    public String update(@PathVariable long id, @PathVariable String firstName, String lastName) {
        User user = userDao.findById(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        userDao.edit(user);
        return user.toString();
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable long id) {
        User user = userDao.findById(id);
        userDao.delete(user);
        return "deleted";
    }
}