package com.good.works.summer.project.service;

import com.good.works.summer.project.entities.Admin;
import com.good.works.summer.project.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class AdminService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByUsername(username);
        if (admin == null) {
            throw new UsernameNotFoundException("Username or Password incorrect!");
        }
        return new User(admin.getUsername(), admin.getPassword(), emptyList());
    }

    public void saveAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    public void encryptPassword(Admin admin) {
        admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
    }

}
