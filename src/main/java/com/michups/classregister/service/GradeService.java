package com.michups.classregister.service;

import com.michups.classregister.entity.Grade;

import java.util.List;

/**
 * Created by michups on 03.08.17.
 */
public interface GradeService {

    public List<Grade> getGrades();
    public Grade getGrade(int id);
    public void delete(int id);
    public void saveGrade(Grade grade);
}
