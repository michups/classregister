package com.michups.classregister.controller;

import com.michups.classregister.entity.Grade;
import com.michups.classregister.entity.Student;
import com.michups.classregister.entity.Teacher;
import com.michups.classregister.service.GradeService;
import com.michups.classregister.service.StudentService;
import com.michups.classregister.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by michups on 18.07.17.
 */

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private GradeService gradeService;
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/home")
    public String goHome() {

        return "redirect:/home/menu";
    }

    @GetMapping("/list")
    public String listTeachers(Model model) {

        List<Teacher> teachers = teacherService.getTeachers();

        model.addAttribute("teachers", teachers);


        return "list-teachers";
    }

    @GetMapping("/showFormAdd")
    public String showFormAdd(Model model) {

        List<Grade> grades = gradeService.getGrades();
        model.addAttribute("grades", grades);

        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);
        return "form-teacher";
    }

    @PostMapping("/saveTeacher")
    public String saveStudent(@ModelAttribute("teacher") Teacher teacher,
                              BindingResult errors) {
        if (errors.hasErrors()) {
            System.out.println("ERRORR");
            System.out.println(errors);
            for (FieldError error : errors.getFieldErrors()) {
                System.out.println(new FieldError("someBean", error.getField(), error.getCode()));
            }
        } else {
            teacher.toString();
            teacherService.saveTeacher(teacher);
        }
        return "redirect:/teacher/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("teacherId") int id,
                                    Model model) {

        List<Grade> grades = gradeService.getGrades();
        model.addAttribute("grades", grades);
        Teacher teacher = teacherService.getTeacher(id);

        model.addAttribute("teacher", teacher);

        return "form-teacher";
    }

    @GetMapping("/delete")
    public String deleteTeacher(@RequestParam("teacherId") int id,
                                Model model) {

        teacherService.delete(id);

        return "redirect:/teacher/list";
    }
}
