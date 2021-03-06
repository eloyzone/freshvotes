package com.github.eloyzone.freshvotes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Eloy 'Elyas' Hadizadeh Tasbiti
 * Created in 3/3/20, 11:58 AM.
 */
@Entity
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private User user;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    private Set<Feature> features = new HashSet<>();
    private Boolean published;


    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Set<Feature> getFeatures()
    {
        return features;
    }

    public void setFeatures(Set<Feature> features)
    {
        this.features = features;
    }

    public Boolean getPublished()
    {
        return published;
    }

    public void setPublished(Boolean published)
    {
        this.published = published;
    }
}
