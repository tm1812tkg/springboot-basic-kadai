package com.example.springkadaitodo.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springkadaitodo.entity.ToDo;
import com.example.springkadaitodo.service.ToDoService;

@Controller
public class ToDoController {
    private final ToDoService todoService;

    public ToDoController(ToDoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todo")
    public String index(Model model) {
       
        List<ToDo> todolist = todoService.findAll();

   
        model.addAttribute("todolist", todolist);

        return "todoView";

    }
}
