package com.github.eloyzone.freshvotes.service;

import com.github.eloyzone.freshvotes.domain.User;
import com.github.eloyzone.freshvotes.repositories.UserRepository;
import com.github.eloyzone.freshvotes.security.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Eloy 'Elyas' Hadizadeh Tasbiti
 * Created in 3/1/20, 11:34 AM.
 */
@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User save(User user)
    {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        Authority authority = new Authority();
        authority.setUser(user);
        authority.setAuthority("ROLE_USER");

        user.getAuthorities().add(authority);

        return userRepository.save(user);
    }
}