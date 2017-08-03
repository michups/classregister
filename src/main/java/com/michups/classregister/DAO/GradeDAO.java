package com.michups.classregister.DAO;

import com.michups.classregister.entity.Grade;

import java.util.List;

/**
 * Created by michups on 18.07.17.
 */
public interface GradeDAO {

    public List<Grade> getGrades();
    public void saveGrade(Grade grade);
    public void  delete(int id);

    public Grade getGrade(int id);
}
