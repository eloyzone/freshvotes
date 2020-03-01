package com.github.eloyzone.freshvotes.controller;

import com.github.eloyzone.freshvotes.domain.User;
import com.github.eloyzone.freshvotes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Eloy 'Elyas' Hadizadeh Tasbiti
 * Created in 3/1/20, 12:16 PM.
 */
@Controller
public class RegisterController
{
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String getRegisterView(ModelMap modelMap)
    {
        System.out.println("register get view");
        modelMap.put("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerAccount(@ModelAttribute User user)
    {
        System.out.println(user);
        userService.save(user);
        return "redirect:/login";
    }
}