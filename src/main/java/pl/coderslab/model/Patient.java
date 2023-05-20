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

    @Column(name = "adress")
    private String adress;

    @PESEL
    @Column(name = "pesel")
    private String pesel;

    @NotEmpty
    @ManyToMany
    @JoinTable(name = "patients_visits",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "visit_id"))
    private List<Visit> visits = new ArrayList<>();


}
