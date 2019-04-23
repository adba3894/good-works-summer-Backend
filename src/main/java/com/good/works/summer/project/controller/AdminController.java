package com.good.works.summer.project.controller;

import com.good.works.summer.project.entities.Admin;
import com.good.works.summer.project.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/signup")
    public void signUp(@RequestBody Admin admin) {
        adminService.encryptPassword(admin);
        adminService.saveAdmin(admin);
    }
}
