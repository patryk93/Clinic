package pl.coderslab.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    private LocalDateTime date;


    @Column(name = "cost")
    private double cost;

    @Column(name = "description")
    private String description;

    @ManyToOne
    private User user;

    @OneToMany
    @JoinColumn(name = "training_plan_id")
    private List<Patient> patients = new ArrayList<>();
}
