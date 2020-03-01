package com.github.eloyzone.freshvotes.security;

import com.github.eloyzone.freshvotes.domain.User;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * @author Eloy 'Elyas' Hadizadeh Tasbiti
 * Created in 2/29/20, 9:56 PM.
 */
@Entity
public class Authority implements GrantedAuthority
{
    private static final long serialVersionUID = -2898504535947580537L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private User user;
    private String authority;

    @Override
    public String getAuthority()
    {
        return this.authority;
    }

    public void setAuthority(String authority)
    {
        this.authority = authority;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}