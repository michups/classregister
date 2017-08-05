package com.michups.classregister.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by michups on 15.07.17.
 */
@Getter
@Setter
@Entity
@Table(name = "grade")
public class Grade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id")
    private Integer gradeId;

    @Column(name = "number")
    private Integer number;

    @Column(name = "alfabet_digit")
    private String alfabetDigit;

    @Column(name = "year")
    @DateTimeFormat(pattern = "yyyy")
    private Integer year;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "teacher_grade",  joinColumns = {
            @JoinColumn(name = "grade_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "teacher_id",
                    nullable = false, updatable = false) })
    public Set<Teacher> teachers = new HashSet<>(0);

    @Override
    public String toString() {
        return number+alfabetDigit;
    }



}
