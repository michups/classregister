package com.michups.classregister.DAO;

import com.michups.classregister.entity.Grade;
import com.michups.classregister.entity.Student;

import java.util.List;

/**
 * Created by michups on 18.07.17.
 */
public interface StudentDAO {

    public List<Student> getStudents();

    public void saveStudent(Student student);

    public void delete(int id);

    public Student getStudent(int id);
}
