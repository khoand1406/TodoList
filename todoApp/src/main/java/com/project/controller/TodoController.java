package com.project.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.Model.Todo;
import com.project.Model.User;
import com.project.Service.TodoImple;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/list-todos")
public class TodoController {

    @Autowired
    private TodoImple todoRepo;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showTodoByUserId(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Todo> todos = todoRepo.getListByUserId(user.getId());
        model.addAttribute("list-todos", todos);
        return "listTodo";
    }

    @RequestMapping(value = "/byDate", method = RequestMethod.GET)
    public String showByDate(Model model, HttpSession session,
            @RequestParam("dateFiler") @DateTimeFormat(pattern = "dd-MM-yyyy") Date date) {
        User user = (User) session.getAttribute("user");
        List<Todo> todosByDate = todoRepo.getListByFilter(String.valueOf(user.getId()), date);
        model.addAttribute("listDate", todosByDate);
        return "listTodo";
    }
}
