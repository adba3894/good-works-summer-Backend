package com.good.works.summer.project.controller;

import com.good.works.summer.project.entities.Admin;
import com.good.works.summer.project.repository.AdminRepository;
import com.good.works.summer.project.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @PostMapping("/signup")
    public void signUp(@RequestBody Admin user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        adminService.saveUser(user);
    }
}
