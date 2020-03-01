package com.github.eloyzone.freshvotes.service;

import com.github.eloyzone.freshvotes.domain.User;
import com.github.eloyzone.freshvotes.repositories.UserRepository;
import com.github.eloyzone.freshvotes.security.CustomSecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Eloy 'Elyas' Hadizadeh Tasbiti
 * Created in 2/29/20, 7:08 PM.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userRepository.findByUsername(username);
        if(user == null)
        {
            throw new UsernameNotFoundException("Invalid Username or Password!");
        }
        return new CustomSecurityUser(user);
    }
}
