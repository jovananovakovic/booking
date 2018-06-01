package com.project.controller;

import com.project.model.json.AuthenticationRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ivan V. on 30-May-18
 */
@RestController
public class AuthController {

    @RequestMapping(method = RequestMethod.POST, value = "login")
    public ResponseEntity<?> authenticationRequest(@RequestBody AuthenticationRequest authenticationRequest) {
        System.out.println(authenticationRequest.getUsername());
        System.out.println(authenticationRequest.getPassword());

        return new ResponseEntity<>("Success",HttpStatus.OK);
    }
}
