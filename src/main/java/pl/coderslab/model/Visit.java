package pl.coderslab.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "visits")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "date")
    private String date;

    @Column(name = "cost")
    private String cost;

    @Column(name = "description")
    private String description;

    @Column(name = "patientDetails")
    private String patientDetails;

    @Column(name = "doctorDetails")
    private String doctorDetails;

    @Column(name = "patientId")
    private Long patientId;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Patient patient;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

//    @ManyToOne
//    private User user;
//
//    @OneToMany
//    @JoinColumn(name = "patient_id")
//    private List<Patient> patients = new ArrayList<>();
}
