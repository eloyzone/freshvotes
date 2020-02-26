package com.github.eloyzone.freshvotes.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Eloy 'Elyas' Hadizadeh Tasbiti
 * Created in 2/26/20, 5:38 PM.
 */
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception
    {
        authenticationManagerBuilder.inMemoryAuthentication().
                withUser("eloy").password("123").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.csrf().disable().
                authorizeRequests().antMatchers("/").permitAll().
                anyRequest().hasRole("USER");
    }
}
