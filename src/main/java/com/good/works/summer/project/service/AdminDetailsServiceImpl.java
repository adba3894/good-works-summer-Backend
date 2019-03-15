package com.good.works.summer.project.service;

import com.good.works.summer.project.entities.Admin;
import com.good.works.summer.project.repository.ApplicationUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private ApplicationUserRepository applicationUserRepository;

    public UserDetailsServiceImpl(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = applicationUserRepository.findByUsername(username);
        if (admin == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(admin.getUsername(), admin.getPassword(), emptyList());
    }
}