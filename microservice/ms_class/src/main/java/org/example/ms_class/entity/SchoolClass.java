package org.example.ms_class.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "school_classes")
public class SchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Long professorId;

    @ElementCollection
    private List<Long> studentIdList;

    public SchoolClass(Long professorId, List<Long> studentIdList) {
        this.professorId = professorId;
        this.studentIdList = studentIdList;
    }

    public SchoolClass() {
    }

    public List<Long> getStudentIdList() {
        return studentIdList;
    }

    public void setStudentIdList(List<Long> studentIdList) {
        this.studentIdList = studentIdList;
    }

    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }

    public long getId() {
        return id;
    }

}
