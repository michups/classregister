package com.michups.classregister.DAO;

import com.michups.classregister.entity.Grade;
import com.michups.classregister.entity.Teacher;

import java.util.List;

/**
 * Created by michups on 18.07.17.
 */
public interface TeacherDAO {

    public List<Teacher> getTeachers();
    public void saveTeacher(Teacher teacher);
    public void  delete(int id);

    public Teacher getTeacher(int id);
}
