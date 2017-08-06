package com.michups.classregister.controller;

import com.michups.classregister.entity.Grade;
import com.michups.classregister.entity.Student;
import com.michups.classregister.service.GradeService;
import com.michups.classregister.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by michups on 18.07.17.
 */

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private GradeService gradeService;

    @GetMapping("/home")
    public String goHome( ){

        return "redirect:/home/menu";
    }
    @GetMapping("/list")
    public String listStudents(Model model){

        List<Student> students = studentService.getStudents();

        model.addAttribute("students", students);

        return "list-students";
    }

    @GetMapping("/showFormAdd")
    public String showFormAdd(Model model){

        List<Grade> grades = gradeService.getGrades();

        model.addAttribute("grades", grades);

        Student student= new Student();

        model.addAttribute("student", student);

        return "form-students";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student,
                              BindingResult errors){
        if(errors.hasErrors()){
            System.out.println("ERRORR");
            System.out.println(errors);
            for (FieldError error : errors.getFieldErrors()) {
                System.out.println(new FieldError("someBean", error.getField(), error.getCode()));
            }
        }
        else {
            student.toString();
            studentService.saveStudent(student);
        }
        return "redirect:/student/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId") int id,
                                    Model model){

        List<Grade> grades = gradeService.getGrades();
        model.addAttribute("grades", grades);
        Student student = studentService.getStudent(id);

        model.addAttribute("student", student);

        return "form-students";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("studentId") int id,
                                    Model model){

        studentService.delete(id);

        return "redirect:/student/list";
    }
}
