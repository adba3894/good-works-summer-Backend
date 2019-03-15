package com.good.works.summer.project.controller;

import com.good.works.summer.project.entities.Admin;
import com.good.works.summer.project.repository.AdminRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class AdminController {

    private AdminRepository adminRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AdminController(AdminRepository adminRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.adminRepository = adminRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody Admin user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        adminRepository.save(user);
    }
}
