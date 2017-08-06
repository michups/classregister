package com.michups.classregister.formatter;

import com.michups.classregister.entity.Grade;
import com.michups.classregister.entity.Teacher;
import com.michups.classregister.service.GradeService;
import com.michups.classregister.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by michups on 05.08.17.
 */
@Component
public class TeacherFormatter implements Formatter<Teacher> {

    @Autowired
    private TeacherService teacherService;

    @Override
    public String print(Teacher teacher, Locale locale) {
        return teacher.toString();
    }

    @Override
    public Teacher parse(String s, Locale locale) throws ParseException {
        return teacherService.getTeacher(Integer.valueOf(s));
    }
}
