package com.github.eloyzone.freshvotes.controller;

import com.github.eloyzone.freshvotes.domain.Product;
import com.github.eloyzone.freshvotes.domain.User;
import com.github.eloyzone.freshvotes.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

/**
 * @author Eloy 'Elyas' Hadizadeh Tasbiti
 * Created in 3/4/20, 11:14 AM.
 */
@Controller
public class ProductController
{
    private Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products/{productId}")
    public String getProduct(@PathVariable Long productId, ModelMap modelMap, HttpServletResponse httpServletResponse) throws IOException
    {
        Optional<Product> productOptional = productRepository.findByIdWithUser(productId);

        if (productOptional.isPresent())
        {
            Product product = productOptional.get();
            modelMap.put("product", product);
        } else
        {
            //todo: replace with throw new ResponseStatusException();
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with id " + productId + " was not found");
            httpServletResponse.sendError(HttpStatus.NOT_FOUND.value(), "Product with id " + productId + " was not found");
        }
        return "product";
    }

    @GetMapping("/p/{productName}")
    public String getProductUserView(@PathVariable String productName, ModelMap modelMap, HttpServletResponse httpServletResponse)
    {
        if (productName != null)
        {
            try
            {
                String decodedProductName = URLDecoder.decode(productName, StandardCharsets.UTF_8.name());
                Optional<Product> productOptional = productRepository.findByName(decodedProductName);
                if (productOptional.isPresent())
                {
                    modelMap.put("product", productOptional.get());
                }
            } catch (UnsupportedEncodingException e)
            {
                logger.error("There was an error decoding a product URL", e);
                e.printStackTrace();
            }
        }
        return "productUserView";
    }

    @PostMapping("/products/{productId}")
    public String updateProduct(@PathVariable Long productId, Product product)
    {
        System.out.println(product);
        productRepository.save(product);
        return "redirect:/products/" + product.getId();
    }


    @PostMapping("/products")
    public String createProduct(@AuthenticationPrincipal User user)
    {
        Product product = new Product();
        product.setPublished(false);
        product.setUser(user);

        product = productRepository.save(product);

        return "redirect:/products/" + product.getId();
    }

}
