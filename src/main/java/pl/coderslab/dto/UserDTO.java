package pl.coderslab.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Objects;
@Getter
@Setter
@Repository
public class UserDTO implements Serializable {

    @PersistenceContext
    EntityManager entityManager;
    private Long id;
    private String login;

    private String firstName;
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        UserDTO userDTO = (UserDTO) o;
//        return Objects.equals(id, userDTO.id) &&
//                Objects.equals(login, userDTO.login);
//    }

    public User findByLogin(String login) {
        return entityManager.find(User.class, login);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, login);
    }


    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", login='" + login + '\'' +
                '}';
    }
}
