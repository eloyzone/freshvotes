package com.github.eloyzone.freshvotes.domain;

import com.github.eloyzone.freshvotes.security.Authority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Eloy 'Elyas' Hadizadeh Tasbiti
 * Created in 2/24/20, 01:06.
 */
@Entity
@Table(name = "users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String name;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Product> products = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Authority> authorities = new HashSet<>();
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Feature> features = new HashSet<>();


    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Set<Authority> getAuthorities()
    {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities)
    {
        this.authorities = authorities;
    }

    public Set<Product> getProducts()
    {
        return products;
    }

    public void setProducts(Set<Product> products)
    {
        this.products = products;
    }

    public Set<Feature> getFeatures()
    {
        return features;
    }

    public void setFeatures(Set<Feature> features)
    {
        this.features = features;
    }

    @Override
    public String toString()
    {
        return "User{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\'' + ", name='" + name + '\'' + ", authorities=" + authorities + '}';
    }
}
