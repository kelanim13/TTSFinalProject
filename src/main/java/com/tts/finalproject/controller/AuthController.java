package com.tts.finalproject.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.finalproject.model.User;
import com.tts.finalproject.service.UserServ;

@Controller
public class AuthController 
{

	@Autowired
    private UserServ userServ;
    
    @GetMapping(value="/")
    public String login()
    {
       
        return "login.html";
    }

    @GetMapping(value="/signup")
    public String registration(Model model)
    {
        User user = new User();
        model.addAttribute("user", user);
        return "signup.html";
    }
    
    @PostMapping(value="/signup")
    public String createNewUser(@Valid User user, BindingResult bindingResult, Model model)
    {
    	if (bindingResult.hasErrors()) {
			return "signup.html";
		}
    	
        User userExists = userServ.findByUsername(user.getUsername());
        if (userExists != null)
        {
            bindingResult.rejectValue("username", "error.user", "Username is already taken");
        }
        if (!bindingResult.hasErrors())
        {
            userServ.saveUser(user);
            model.addAttribute("Success", "Sign up successful!");
            model.addAttribute("user", new User());
        }
        return "signup.html"; 
    }    
}
