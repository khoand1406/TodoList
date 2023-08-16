package com.project.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Model.ResponseMessage;

@RestController
@RequestMapping(value = Constant.URI_API)
public class PingController {
    @RequestMapping("/ping")
    public ResponseEntity<ResponseMessage> ping() {
        return new ResponseEntity<>(ResponseMessage.info("connected"), HttpStatus.OK);
    }
}
