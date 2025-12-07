package com.devmind.springapp.homeworkc20.service;


import com.devmind.springapp.homeworkc20.models.*;
import com.devmind.springapp.homeworkc20.repository.*;
import jakarta.persistence.criteria.JoinType;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UnivService {

    private final StudentRepository studentRepository;
    private final ProfesorRepository profesorRepository;
    private final AdresaRepository adresaRepository;
    private final MaterieRepository materieRepository;
    private final StudentiToMaterieRepository studentiToMaterieRepository;





    public Profesor getProfesorById(int id){
        return profesorRepository.findById(id).orElse(null);
    }

    public Profesor getProfesorWithMaterii (int id){
        Specification<Profesor> specification = (root, query, criteriaBuilder) -> {
            query.distinct(true);

            root.fetch("materiiPredate", JoinType.LEFT);

            return criteriaBuilder.equal(root.get("id"), id);
        };
        return profesorRepository.findOne(specification).orElseThrow(()-> new RuntimeException("Profesorul nu a fost gasit"));
    }


    @Transactional
    public Student enrollStudentToMaterii(Integer studentId, Integer materieId){
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Studentul cu id " + studentId + " nu există"));

        Materie materie = materieRepository.findById(materieId)
                .orElseThrow(() -> new IllegalArgumentException("Materia cu id " + materieId + " nu există"));

        StudentiToMaterie inscriere = new StudentiToMaterie();
        inscriere.setStudent(student);
        inscriere.setMaterie(materie);
        studentiToMaterieRepository.save(inscriere);


        student.getCursuriAlese().add(materie);
        materie.getStudentiInrolati().add(student);

        return studentRepository.save(student);

    }


    @Transactional
    public Student addStudentWithAdress (Student student){
        return studentRepository.save(student);
    }

    public Student updateStudentAdress (Integer studentId, Adresa adresaUpdate){
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Studentul cu id " + studentId + " nu există"));


        Adresa adresa = student.getAdresa();
        if(adresa == null){
            adresa = new Adresa();
        }
        adresa.setStrada(adresaUpdate.getStrada());
        adresa.setNumar(adresaUpdate.getNumar());
        adresa.setLocalitate(adresaUpdate.getLocalitate());

        adresa = adresaRepository.save(adresa);
        student.setAdresa(adresa);

        return studentRepository.save(student);


    }

    public void deleteStudentAndRelations (Integer studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Studentul cu id " + studentId + " nu există"));

        if(student.getCursuriAlese() != null){
            for(Materie materie : student.getCursuriAlese()){
                if(materie.getStudentiInrolati() != null){
                    materie.getStudentiInrolati().remove(student);
                }
            }
            student.getCursuriAlese().clear();
        }

        if(student.getInscrieri() != null && student.getInscrieri().isEmpty()){
            studentiToMaterieRepository.deleteAll(student.getInscrieri());
            student.getInscrieri().clear();
        }

        Adresa adresa = student.getAdresa();
        if(adresa != null){
            student.setAdresa(null);
            adresaRepository.delete(adresa);
        }
        studentRepository.delete(student);


    }

















}
