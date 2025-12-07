package com.devmind.springapp.homeworkc20.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "adrese_studenti")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Adresa {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "strada")
    private String strada;

    @Column(name = "numar")
    private String numar;

    @Column(name = "localitate")
    private String localitate;

    @OneToOne(mappedBy = "adresa")
    @JsonBackReference
    private Student student;
}