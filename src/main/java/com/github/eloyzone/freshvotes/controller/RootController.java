package com.github.eloyzone.freshvotes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Eloy 'Elyas' Hadizadeh Tasbiti
 * Created in 3/1/20, 12:18 PM.
 */
@Controller
public class RootController
{
    //    @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String getRootView()
    {
        return "index";
    }
}