package pl.coderslab.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.mindrot.jbcrypt.BCrypt;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Getter
@Setter
public class RegisterDTO {
    @NotNull @NotBlank (message = "Pole nie może być puste") @Size(min = 5, max = 20, message = "Login musi mieć od 5 do 20 znaków" )
    private String login;
    @NotNull @NotBlank (message = "Pole nie może być puste") @Email (message = "Niepoprawny email")
    private String email;
    @NotNull @NotBlank (message = "Pole nie może być puste")
    private String password;
    @NotNull @NotBlank (message = "Pole nie może być puste")
    private String confirmedPassword;
    @NotNull (message = "Pole nie może być puste") @Size(min = 3, message = "Imię musi być dłuższe niż 3 znaki" )
    private String firstName;
    @NotNull (message = "Pole nie może być puste") @Size(min = 3, message = "Imię musi być dłuższe niż 3 znaki" )
    private String lastName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterDTO that = (RegisterDTO) o;
        return Objects.equals(login, that.login) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(confirmedPassword, that.confirmedPassword) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(login, email, password, confirmedPassword, firstName, lastName);
    }


}
