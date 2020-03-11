package com.github.eloyzone.freshvotes.controller;

import com.github.eloyzone.freshvotes.domain.Feature;
import com.github.eloyzone.freshvotes.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Optional;

/**
 * @author Eloy 'Elyas' Hadizadeh Tasbiti
 * Created in 3/9/20, 8:43 PM.
 */
@Controller
@RequestMapping("/products/{productId}/features")
public class FeatureController
{
    @Autowired
    private FeatureService featureService;

    @PostMapping("") // this maps to "/products/{productId}/features"
    public String createFeature(@PathVariable Long productId)
    {
        Feature feature = featureService.createFeature(productId);

        return "redirect:/products/"+productId+"/features/"+feature.getId();
    }

    @GetMapping("{featureId}")
    public String getFeature(@PathVariable Long productId, @PathVariable Long featureId, ModelMap modelMap)
    {
        Optional<Feature> featureOptional = featureService.findById(featureId);
        if(featureOptional.isPresent())
        {
            modelMap.put("feature", featureOptional.get());
        }
        return "feature";
    }

    @PostMapping("{featureId}")
    public String updateFeature(@PathVariable Long productId, @PathVariable Long featureId, Feature feature)
    {
        feature = featureService.save(feature);
        try
        {
            String encodedProductName = URLEncoder.encode(feature.getProduct().getName(), "UTF-8");
            return "redirect:/p/"+encodedProductName;
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
            return "redirect:/dashboard";
        }

    }
}

