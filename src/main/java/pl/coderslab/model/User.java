package pl.coderslab.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "login")
    private String login;

    @NotBlank
    @Column(name = "firstName")
    private String firstName;

    @NotBlank
    @Column(name = "lastName")
    private String lastName;


    @Column(name = "password")
    private String password;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "adress")
    private String adress;

    @PESEL
    @Column(name = "pesel")
    private String pesel;

    @Column(name = "superadmin") // if user is superadmin
    private Integer superadmin;

    @Column(name = "enable") // if user is active
    private Integer enable;

    @Column(name = "doctor") // if user is doctor
    private Integer doctor;

    @Transient
    private String confirmedPassword;


}