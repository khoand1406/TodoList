package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.DAO.iInterface.SubTodoInterface;
import com.project.DAO.iInterface.TodoInteface;
import com.project.Model.SubTodo;
import com.project.Model.Todo;

@Controller
@RequestMapping("/subtodos")
public class SubTodoController {

    @Autowired
    private SubTodoInterface subRepo;

    @Autowired
    private TodoInteface todoRepo;

    @RequestMapping(value = "/todo/{id}/", method = RequestMethod.GET)
    public String getSubTodo(@PathVariable("id") Long id, Model model) {
        Todo todo = todoRepo.geTodo(id);
        Long todoId = todo.getId();
        List<SubTodo> subs = subRepo.getByTodo(todoId);
        model.addAttribute("listSubs", subs);
        return "subtodo/listSubTodo";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createNewTodo(Model model) {
        List<Todo> todos = todoRepo.findAll();
        model.addAttribute("todos", todos);
        model.addAttribute("subtodo", new SubTodo());
        return "subtodo/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String processCreate(@ModelAttribute("subtodo") SubTodo sub) {
        subRepo.addSubTodo(sub);
        return "redirect:/subtodos";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateTodo(Model model) {
        List<Todo> todos = todoRepo.findAll();
        model.addAttribute("todos", todos);
        model.addAttribute("subtodo", new SubTodo());
        return "subtodo/update";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)

    public String processUpdate(@PathVariable("id") Long id, @ModelAttribute("subtodo") SubTodo sub) {
        subRepo.updateSub(id, sub);
        return "redirect:/subtodos";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteSubTodo(@PathVariable("id") Long id) {
        SubTodo sub = subRepo.get(id);
        subRepo.delete(sub);
        return "redirect:/subtodos";
    }
}
