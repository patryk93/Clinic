package pl.coderslab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;
import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String saveToDb(User user){
        Long id = userRepository.returnIdWhenNameFound(user.getLogin());
        if(id != user.getId() && id != null){
            return "name";
        }
        id = userRepository.returnIdWhenEmailFound(user.getEmail());
        if(id != user.getId() && id != null){
            return "email";
        }

        userRepository.save(user);

        return "ok";
    }

    public User findUserByName(String name){
        return userRepository.findUserByName(name);
    }
}
