package pl.coderslab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.dto.UserDTO;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserLoginDataRepository;
import pl.coderslab.repository.UserRepository;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserLoginDataRepository userLoginDataRepository;


    public boolean validate(String login, String password) {
        Boolean check = userLoginDataRepository.checkCredentials(login, password);
        return check != null ? check : false;
    }

    public UserDTO login(String login) {
        User user = userRepository.findByLogin(login);
        UserDTO userDao = new UserDTO();
        userDao.setLogin(user.getLogin());
        userDao.setFirstName(user.getFirstName());
        userDao.setId(user.getId());
        return userDao;
    }
}
