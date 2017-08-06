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

import java.util.List;

/**
 * Created by michups on 18.07.17.
 */

@Controller
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private GradeService gradeService;

    @GetMapping("/home")
    public String goHome() {

        return "redirect:/home/menu";
    }

    @GetMapping("/list")
    public String listGrades(Model model) {

        List<Grade> grades = gradeService.getGrades();

        model.addAttribute("grades", grades);


        return "list-grades";
    }

    @GetMapping("/showFormAdd")
    public String showFormAdd(Model model) {

        List<Teacher> teachers = teacherService.getTeachers();
        model.addAttribute("teachers", teachers);

        Grade grade = new Grade();
        model.addAttribute("grade", grade);
        return "form-grades";
    }

    @PostMapping("/saveGrade")
    public String saveGrade(@ModelAttribute("grade") Grade grade,
                            BindingResult errors) {
        if (errors.hasErrors()) {
            System.out.println("ERRORR");
            System.out.println(errors);
            for (FieldError error : errors.getFieldErrors()) {
                System.out.println(new FieldError("someBean", error.getField(), error.getCode()));
            }
        } else {
            gradeService.saveGrade(grade);
        }
        return "redirect:/grade/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("gradeId") int id,
                                    Model model) {

        List<Teacher> teachers = teacherService.getTeachers();
        model.addAttribute("teachers", teachers);

        Grade grade = gradeService.getGrade(id);
        model.addAttribute("grade", grade);

        return "form-grades";
    }

    @GetMapping("/delete")
    public String deleteGrade(@RequestParam("gradeId") int id,
                              Model model) {

        try {
            gradeService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/grade/list";
    }
}
