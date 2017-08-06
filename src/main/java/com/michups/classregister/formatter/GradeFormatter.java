package com.michups.classregister.formatter;

import com.michups.classregister.entity.Grade;
import com.michups.classregister.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by michups on 05.08.17.
 */
@Component
public class GradeFormatter implements Formatter<Grade> {

    @Autowired
    private GradeService gradeService;

    @Override
    public String print(Grade grade, Locale locale) {
        return grade.getNumber() + grade.getAlfabetDigit();
    }

    @Override
    public Grade parse(String s, Locale locale) throws ParseException {
        return gradeService.getGrade(Integer.valueOf(s));
    }
}
