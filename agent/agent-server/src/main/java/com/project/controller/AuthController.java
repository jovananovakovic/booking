package com.project.controller;

import com.project.model.User;
import com.project.services.RepositoryService;
import com.project.services.SyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

/**
 * Created by Ivan V. on 30-May-18
 */
@RestController
public class AuthController {


    @Autowired
    private RepositoryService services;

    @Autowired
    private SyncService syncService;

    @RequestMapping(method = RequestMethod.POST,
            value = "login",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<com.project.DTO.Credentials> authenticationRequest(@RequestBody com.project.DTO.Credentials credentials) {
        User user = services.findByUsername(credentials.getUsername());
        if (user != null) {
            if (user.getPassword().equals(credentials.getPassword())) {
                ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
                HttpSession session = attr.getRequest().getSession(true);
                session.setAttribute("user", user);

                System.out.print("  ___  " + user.getUsername());
                // syncService.syncWholeDb();
                try {
                    syncService.syncWholeDb();
                } catch (Exception e) {
                    e.printStackTrace();
                }


                return new ResponseEntity<com.project.DTO.Credentials>(credentials, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @RequestMapping(value = "/logOut",
            method = RequestMethod.GET)
    public ResponseEntity logOut() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession(true);
        session.invalidate();


        return new ResponseEntity(HttpStatus.OK);
    }


}
