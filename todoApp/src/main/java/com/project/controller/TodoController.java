package com.project.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.Model.Category;
import com.project.Model.Todo;
import com.project.Model.User;
import com.project.Service.CategoryImpl;
import com.project.Service.TodoImple;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/list-todos")
public class TodoController {

    @Autowired
    private TodoImple todoRepo;

    @Autowired
    private CategoryImpl cateRepo;

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

    @RequestMapping(value = "/add-Todo", method = RequestMethod.GET)
    public String createNewTodo(HttpSession session, @ModelAttribute("todoForm") Todo todo, Model model) {
        List<Category> listCate = cateRepo.findAll();
        model.addAttribute("listCate", listCate);
        return "add-todo";
    }

    @RequestMapping(value = "/add-Todo", method = RequestMethod.POST)
    public String addTodo(HttpSession session, @ModelAttribute("todoForm") Todo todo) {
        User user = (User) session.getAttribute("user");
        todoRepo.addTodo(user.getId(), todo.getTitle(), todo.getDescription(), todo.getDate(), todo.isIsDone(),
                todo.getCategory().getCategoryid());
        return "redirect:/listTodo";
    }

    @RequestMapping(value = "/update-todo/{id}", method = RequestMethod.GET)
    public String updateForm(Model model, @ModelAttribute("todo") Todo todo, HttpSession session,
            @PathVariable("id") Long id) {
        List<Category> listCate = cateRepo.findAll();
        User user = (User) session.getAttribute("user");
        Optional<Todo> todoFirst = todoRepo.geTodoById(id);
        model.addAttribute("listCate", listCate);
        model.addAttribute("user", user);
        model.addAttribute("before", todoFirst);
        return "update";

    }

    @RequestMapping(value = "/delete-todo/{id}", method = RequestMethod.GET)
    public String deleteTodo(@PathVariable("id") Long id) {
        Todo todo = todoRepo.geTodoById(id);
        todoRepo.deleteTodo(todo);
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateTodo(HttpSession session, @ModelAttribute("todoForm") Todo todo) {
        todoRepo.updateTodo(todo);
        return "redirect:/listTodo";
    }

}
