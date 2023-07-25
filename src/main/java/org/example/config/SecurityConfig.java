package org.example.config;

import static org.example.model.Role.RoleName.ADMIN;
import static org.example.model.Role.RoleName.USER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/register").permitAll()
                .antMatchers(HttpMethod.GET, "/cinema-halls/*").permitAll()
                .antMatchers(HttpMethod.POST, "/cinema-halls/*").hasRole(ADMIN.name())
                .antMatchers(HttpMethod.GET, "/movies").permitAll()
                .antMatchers(HttpMethod.POST, "/movies").hasRole(ADMIN.name())
                .antMatchers(HttpMethod.GET,"/movie-sessions/available")
                .hasAnyRole(ADMIN.name(), USER.name())
                .antMatchers(HttpMethod.PUT,"/movie-sessions/{id}").hasRole(ADMIN.name())
                .antMatchers(HttpMethod.DELETE,"/movie-sessions/{id}").hasRole(ADMIN.name())
                .antMatchers(HttpMethod.POST,"/movie-sessions/*").hasRole(ADMIN.name())
                .antMatchers("orders/*").hasRole(USER.name())
                .antMatchers("/shopping-carts/*").hasRole(USER.name())
                .antMatchers(HttpMethod.GET,"/users/*").hasRole(ADMIN.name())
                .anyRequest().authenticated()
                .and()
                .formLogin();
    }
}
