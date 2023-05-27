package pl.coderslab.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
@Getter
@Setter
public class UserDTO {

    private Long id;
    private String login;

    private String firstName;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(id, userDTO.id) &&
                Objects.equals(login, userDTO.login);
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
