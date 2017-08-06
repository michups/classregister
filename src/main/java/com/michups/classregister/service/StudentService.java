package com.michups.classregister.service;

import com.michups.classregister.entity.Grade;
import com.michups.classregister.entity.Student;

import java.util.List;

/**
 * Created by michups on 03.08.17.
 */
public interface StudentService {

    public List<Student> getStudents();

    public Student getStudent(int id);

    public void delete(int id);

    public void saveStudent(Student student);
}
