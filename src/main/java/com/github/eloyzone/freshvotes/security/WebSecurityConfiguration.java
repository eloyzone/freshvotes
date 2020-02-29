package com.github.eloyzone.freshvotes.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Eloy 'Elyas' Hadizadeh Tasbiti
 * Created in 2/26/20, 5:38 PM.
 */
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter
{
    @Bean
    public PasswordEncoder getPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception
    {
        authenticationManagerBuilder.inMemoryAuthentication().
                passwordEncoder(getPasswordEncoder()).
                withUser("eloy").password(getPasswordEncoder().encode("123")).roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests().
                antMatchers("/").permitAll().
                anyRequest().hasRole("USER").and().
                formLogin().loginPage("/login").permitAll().and().
                logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll();
    }
}
