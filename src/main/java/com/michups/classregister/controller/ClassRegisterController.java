package com.michups.classregister.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by michups on 18.07.17.
 */

@Controller
@RequestMapping("/home")
public class ClassRegisterController {

    @GetMapping("/menu")
    public String goHome(){

        return "home";
    }

    @GetMapping("/student")
    public String goToStudent( ){

        return "redirect:/student/list";
    }

    @GetMapping("/grade")
    public String goToGrade( ){

        return "redirect:/grade/list";
    }

    @GetMapping("/teacher")
    public String goToTeacher( ){

        return "redirect:/teacher/list";
    }

}
