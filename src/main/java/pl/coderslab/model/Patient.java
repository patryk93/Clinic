package pl.coderslab.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "firstName")
    private String firstName;

    @NotBlank
    @Column(name = "lastName")
    private String lastName;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "houseNumber")
    private String houseNumber;

    @Column(name = "apartmentNumber")
    private String apartmentNumber;

    @PESEL
    @Column(name = "pesel")
    private String pesel;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.REMOVE)
    private List<Visit> visit;


}
