package com.project.api.Users;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.api.Constant;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping(value = Constant.URI_API)
public class UserController {
    @RequestMapping(value = "/user")
    public ResponseEntity<Map<String, Object>> user(HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        map.put("user", session.getAttribute("user"));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
