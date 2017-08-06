package com.michups.classregister.service;

import com.michups.classregister.entity.Grade;
import com.michups.classregister.entity.Student;
import com.michups.classregister.entity.Teacher;

import java.util.List;

/**
 * Created by michups on 03.08.17.
 */
public interface TeacherService {

    public List<Teacher> getTeachers();

    public Teacher getTeacher(int id);

    public void delete(int id);

    public void saveTeacher(Teacher teacher);
}
