package com.github.eloyzone.freshvotes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Eloy 'Elyas' Hadizadeh Tasbiti
 * Created in 2/26/20, 4:44 PM.
 */
@Controller
public class DashboardController
{

//    @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String getRootView()
    {
        return "index";
    }
}
