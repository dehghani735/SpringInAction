package com.mdt.tacobar.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("userRepositoryUserDetailsService")
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/design", "/orders/**")
            .access("hasRole('ROLE_USER')")
            .antMatchers("/", "/**").permitAll()
            .and()
            .formLogin()
            .loginPage("/login")
//                .defaultSuccessUrl("/design", true)
            .and()
            .logout()
            .logoutSuccessUrl("/")
            .and()
            .csrf()
            .ignoringAntMatchers("/h2-console/**")
            .and()
            .headers()
            .frameOptions()
            .sameOrigin()
        ;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new StandardPasswordEncoder("53cr3t");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
        throws Exception {

        auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(encoder());

//        in this method we will use AuthenticationManagerBuilder object to specify how users will be looked
//        up during authentication.

//        In-memory user store
//        auth
//                .inMemoryAuthentication()
//                .withUser("buzz")
//                .password("infinity")
//                .authorities("ROLE_USER")
//                .and()
//                .withUser("woody")
//                .password("bullseye")
//                .authorities("ROLE_USER");

//        JDBC-based user store

//        auth
//                .jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery( // overriding the default user queries
//                        "select username, password, enabled from Users" +
//                        "where username=?")
//                .authoritiesByUsernameQuery(
//                        "select username, authority from UserAuthorities" +
//                        "where username=?")
//                .passwordEncoder(new StandardPasswordEncoder("53cr3t"));

//        LDAP-backed user store

//        auth
//                .ldapAuthentication()
//                .userSearchBase("ou=people")
//                .userSearchFilter("(uid={0})")
//                .groupSearchBase("ou=groups")
//                .groupSearchFilter("member={0}")
//                .contextSource()
//                .root("dc=tacocloud,dc=com")
//                .and()
//                .passwordCompare()
//                .passwordEncoder(new BCryptPasswordEncoder())
//                .passwordAttribute("passcode");
    }
}
