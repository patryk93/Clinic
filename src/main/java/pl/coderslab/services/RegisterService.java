package pl.coderslab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.dto.RegisterDTO;
import pl.coderslab.model.User;
import pl.coderslab.model.UserLoginData;
import pl.coderslab.repository.UserLoginDataRepository;
import pl.coderslab.repository.UserRepository;

@Service
public class RegisterService {
    @Autowired
    private UserLoginDataRepository userLoginDataRepository;

    @Autowired
    private UserRepository userRepository;

    public void register(RegisterDTO form) {
        String login = form.getLogin();
        String email = form.getEmail();
        String firstName = form.getFirstName();
        String lastName = form.getLastName();
        String password = form.getPassword();

        Boolean loginUsed = userRepository.isLoginUsed(login);
        if (loginUsed != null && loginUsed) {
            throw new IllegalArgumentException("Login zajęty");
        }
        Boolean emailUsed = userRepository.isEmailUsed(email);
        if (emailUsed != null && emailUsed) {
            throw new IllegalArgumentException("Email zajęty");
        }
        User user = new User();
        user.setLogin(login);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        userRepository.save(user);


        UserLoginData loginData = new UserLoginData();
        loginData.setUser(user);
        loginData.setPassword(password);
        userLoginDataRepository.save(loginData);

    }
}