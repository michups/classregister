package com.michups.classregister.service;

import com.michups.classregister.DAO.GradeDAO;
import com.michups.classregister.entity.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by michups on 03.08.17.
 */
@Service
public class GradeServiceImpl implements GradeService{

    @Autowired
    private GradeDAO gradeDAO;

    @Override
    @Transactional
    public List<Grade> getGrades(){
        return gradeDAO.getGrades();
    }

    @Override
    @Transactional
    public Grade getGrade(int id){
        return gradeDAO.getGrade(id);
    }

    @Override
    @Transactional
    public void delete(int id){
     gradeDAO.delete(id);
    }

    @Override
    @Transactional
    public void saveGrade(Grade grade){
        gradeDAO.saveGrade(grade);
    };
}
