package com.michups.classregister.service;

import com.michups.classregister.DAO.GradeDAO;
import com.michups.classregister.DAO.StudentDAO;
import com.michups.classregister.entity.Grade;
import com.michups.classregister.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by michups on 03.08.17.
 */
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDAO studentDAO;

    @Override
    @Transactional
    public List<Student> getStudents(){
        return studentDAO.getStudents();
    }

    @Override
    @Transactional
    public Student getStudent(int id){
        return studentDAO.getStudent(id);
    }

    @Override
    @Transactional
    public void delete(int id){
        studentDAO.delete(id);
    }

    @Override
    @Transactional
    public void saveStudent(Student student){
        studentDAO.saveStudent(student);
    }
}
