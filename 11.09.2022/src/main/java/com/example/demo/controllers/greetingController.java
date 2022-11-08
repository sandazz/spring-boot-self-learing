package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.ModelAndViewResolver;

import com.example.demo.model.students;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import javassist.expr.NewArray;

@Controller
public class greetingController {
    @RequestMapping("/page01")
    public ModelAndView getPage01(){
        return new ModelAndView("page01.html");
    }
    @RequestMapping("/demo")
    public ModelAndView getDemo(){
        return new ModelAndView("demo.html");

    }

    @RequestMapping("/students")
    public String listStudents(HttpServletRequest request, Model model){
        
        List<students> studentList = new ArrayList<students>();
        studentList.add(new students("tharuka", 23));
        studentList.add(new students("saman", 25));

        model.addAttribute("studentList", studentList);


        return "students";
    }
    
    @RequestMapping("/create")
    public String createStudent(@ModelAttribute students students, Model model){
       System.out.print(students.getName());
       System.out.print(students.getAge());
       List<students> studentList = new ArrayList<students>();
       studentList.add(students);
       model.addAttribute("studentList", studentList);


       return "students";
    }

    @RequestMapping("/new-student")
    public String newStudent( Model model){
        students student = new students();
        model.addAttribute("students", student);
        return "form";
    }

}
