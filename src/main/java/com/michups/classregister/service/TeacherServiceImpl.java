package com.michups.classregister.service;

import com.michups.classregister.DAO.GradeDAO;
import com.michups.classregister.DAO.TeacherDAO;
import com.michups.classregister.entity.Grade;
import com.michups.classregister.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by michups on 03.08.17.
 */
@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherDAO teacherDAO;

    @Override
    @Transactional
    public List<Teacher> getTeachers() {
        return teacherDAO.getTeachers();
    }

    @Override
    @Transactional
    public Teacher getTeacher(int id) {
        return teacherDAO.getTeacher(id);
    }



    @Override
    @Transactional
    public void delete(int id){
     teacherDAO.delete(id);
    }

    @Override
    @Transactional
    public void saveTeacher(Teacher teacher) {
        teacherDAO.saveTeacher(teacher);
    }
}
