package com.michups.classregister.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by michups on 15.07.17.
 */
@Getter
@Setter
@Entity
@Table(name = "grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id")
    private Integer gradeId;

    @Column(name = "number")
    private Integer number;

    @Column(name = "alfabet_digit")
    private String alfabetDigit;

    @Column(name = "year")
    private Integer year;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "teacher_grade",  joinColumns = {
            @JoinColumn(name = "greade_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "teacher_id",
                    nullable = false, updatable = false) })
    private Set<Teacher> teachers = new HashSet<>(0);

    @Override
    public String toString() {
        return "Grade{" +
                "gradeId=" + gradeId +
                ", number=" + number +
                ", alfabetDigit='" + alfabetDigit + '\'' +
                ", year=" + year +
                '}';
    }



}
