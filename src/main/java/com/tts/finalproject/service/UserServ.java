package com.tts.finalproject.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tts.finalproject.model.Role;
import com.tts.finalproject.model.User;
import com.tts.finalproject.repository.RoleRepo;
import com.tts.finalproject.repository.UserRepo;

@Service
public class UserServ
{    
    private UserRepo userRepo;
    private RoleRepo roleRepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private UserServ(UserRepo userRepo,
                        RoleRepo roleRepo,
                        BCryptPasswordEncoder bCryptPasswordEncoder)
    {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    public User findByUsername(String username)
    {
        return userRepo.findByUsername(username);
    }
    
    public List<User> findAll()
    {
        return (List<User>)userRepo.findAll();
    }
    

    public void save(User user)
    {
        userRepo.save(user);
    }
    

    public User saveUser(User user)
    {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepo.findByRole("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepo.save(user);
    }
    
    public User getLoggedUser()
    {
        String loggedInUsername =
                SecurityContextHolder.getContext().getAuthentication().getName();
        return findByUsername(loggedInUsername);
    }
}