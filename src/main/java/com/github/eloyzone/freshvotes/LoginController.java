package com.github.eloyzone.freshvotes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Eloy 'Elyas' Hadizadeh Tasbiti
 * Created in 2/26/20, 8:16 PM.
 */
@Controller
public class LoginController
{
    @GetMapping("/login")
    public String getLoginView()
    {
        return "login";
    }
}
