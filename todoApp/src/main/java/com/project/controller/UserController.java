package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.Model.User;
import com.project.Service.UserImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserImpl userRepo;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loadLogin(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("user") User user, Model model, HttpSession session) {
        User usercheck = userRepo.getAuthenticated(user.getUsername(), user.getPassword());
        if (usercheck == null) {
            String message = "Incorret name or password";
            model.addAttribute("message", message);
            return "redirect:/login";
        } else {

            session.setAttribute("user", usercheck);
            return "redirect:/home";
        }

    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegist(@ModelAttribute("user") User user, BindingResult result) {
        User existing = userRepo.findByEmail(user.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()) {
            return "login";
        }

        userRepo.getNewAuthen(user);

    }
}
