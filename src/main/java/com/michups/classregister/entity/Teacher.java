package com.michups.classregister.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by michups on 15.07.17.
 */
@Getter
@Setter
@Entity
@Table(name = "teacher")
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Integer teacherId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grade_id", nullable = false)
    public Grade mainClass;

    @Column(name = "email")
    private String email;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "teacher_grade",
            joinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "grade_id", referencedColumnName = "grade_id"))

    public List<Grade> grades;

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
