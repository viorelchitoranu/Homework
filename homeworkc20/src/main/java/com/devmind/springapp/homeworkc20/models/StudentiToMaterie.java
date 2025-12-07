package com.devmind.springapp.homeworkc20.models;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "studenti_to_materii")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentiToMaterie {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_materie")
    private Materie materie;
}