package com.github.eloyzone.freshvotes.service;

import com.github.eloyzone.freshvotes.domain.Feature;
import com.github.eloyzone.freshvotes.domain.Product;
import com.github.eloyzone.freshvotes.repositories.FeatureRepository;
import com.github.eloyzone.freshvotes.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Eloy 'Elyas' Hadizadeh Tasbiti
 * Created in 3/9/20, 8:48 PM.
 */
@Service
public class FeatureService
{
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private FeatureRepository featureRepository;

    public Feature createFeature(Long productId)
    {
        Feature feature = new Feature();

        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isPresent())
        {
            Product product = productOptional.get();
            feature.setProduct(product);
            product.getFeatures().add(feature);

            feature.setStatus("Pending Review");

            featureRepository.save(feature);
            return feature;
        }
        return feature;
    }

    public Feature save(Feature feature)
    {
        return featureRepository.save(feature);
    }

    public Optional<Feature> findById(Long featureId)
    {
        return featureRepository.findById(featureId);
    }
}
