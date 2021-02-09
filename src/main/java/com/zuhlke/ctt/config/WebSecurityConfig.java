package com.zuhlke.ctt.config;/*
 * Created by  paria
 * Date:       2/9/2021
 * Time:       8:57 PM
 */

/*import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("u")
                .password("$2a$04$EJVvHPmCJMQTXr8IAF7nvOlcqBMxvJoVS8j8thhdnLhVw2fj6oWfa")
                .roles("USER")
                .and()
                .withUser("a")
                .password("$2a$04$ViS.5RB05tL9Bnu9LpZR5OIH0yZfetgqVbHf5exvu5CceslkvTZ12")
                .roles("ADMIN")
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .and().authorizeRequests()
                .antMatchers(
                        "/", "/csrf",
                        "/v2/api-docs",
                        "/swagger-resources/**",
                        "/swagger-ui.html",
                        "/webjars/**"
                ).permitAll()
                .anyRequest().authenticated();
}
    }*/
