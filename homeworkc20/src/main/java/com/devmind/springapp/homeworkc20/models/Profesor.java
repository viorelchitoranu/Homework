package com.devmind.springapp.homeworkc20.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity
@Table(name = "profesori")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Profesor {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nume")
    private String nume;

    @OneToMany(mappedBy = "profesor")
    private Set<Materie> materiiPredate;


}
