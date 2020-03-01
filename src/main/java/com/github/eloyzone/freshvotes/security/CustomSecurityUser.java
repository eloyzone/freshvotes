package com.github.eloyzone.freshvotes.security;

import com.github.eloyzone.freshvotes.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Set;

/**
 * @author Eloy 'Elyas' Hadizadeh Tasbiti
 * Created in 2/29/20, 9:54 PM.
 */
public class CustomSecurityUser extends User implements UserDetails
{
    private static final long serialVersionUID = -3368035792847608897L;

    public CustomSecurityUser()
    {
    }

    public CustomSecurityUser(User user)
    {
        this.setId(user.getId());
        this.setName(user.getName());
        this.setUsername(user.getUsername());
        this.setPassword(user.getPassword());
        this.setAuthorities(user.getAuthorities());
    }

    @Override
    public Set<Authority> getAuthorities()
    {
        return super.getAuthorities();
    }

    @Override
    public String getPassword()
    {
        return super.getPassword();
    }

    @Override
    public String getUsername()
    {
        return super.getUsername();
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }
}
