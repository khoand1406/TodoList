package com.project.api.Todos;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.Model.Category;
import com.project.Model.Todo;
import com.project.Model.User;
import com.project.Service.CategoryImpl;
import com.project.Service.TodoImple;
import com.project.Service.UserService;
import com.project.api.Constant;

@RestController
@RequestMapping(value = Constant.URI_API + Constant.URI_Todos)
public class TodoController {
    private static final Logger log = LoggerFactory.getLogger(TodoController.class);

    @Autowired
    private TodoImple todoRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryImpl categoryImpl;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Todo>> getTodos(Authentication authentication) {
        String username = authentication.getName();
        User user = userService.findByUsername(username);
        List<Todo> todos = todoRepo.getListByUserId(user.getId());
        return new ResponseEntity<>(todos, HttpStatus.OK);

    }

    @RequestMapping(value = "/{cateId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Todo>> getTodosByCategory(Authentication authentication,
            @RequestParam("cateId") Long cateIDLong) {
        String username = authentication.getName();
        User user = userService.findByUsername(username);
        Category category = categoryImpl.findById(cateIDLong).get();
        List<Todo> todos = todoRepo.getListByCategory(user.getId(), category.getCategoryid());
        return new ResponseEntity<List<Todo>>(todos, HttpStatus.OK);
    }
}