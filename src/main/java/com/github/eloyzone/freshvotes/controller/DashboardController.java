package com.github.eloyzone.freshvotes.controller;

import com.github.eloyzone.freshvotes.domain.Product;
import com.github.eloyzone.freshvotes.domain.User;
import com.github.eloyzone.freshvotes.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Eloy 'Elyas' Hadizadeh Tasbiti
 * Created in 2/26/20, 4:44 PM.
 */
@Controller
public class DashboardController
{
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/dashboard")
    public String getDashboardView(@AuthenticationPrincipal User user, ModelMap modelMap)
    {
        List<Product> products = productRepository.findByUser(user);
        modelMap.put("products", products);
        return "dashboard";
    }
}