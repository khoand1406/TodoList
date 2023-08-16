package com.project.api.Todos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Service.TodoImple;
import com.project.api.Constant;

@RestController
@RequestMapping(value = Constant.URI_API + Constant.URI_Todos)
public class TodoController {
    private static final Logger log= LoggerFactory.getLogger(TodoController.class);
   
    @Autowired 
    private TodoImple todoRepo;

    @RequestMapping(value="", method= RequestMethod.GET)


}
