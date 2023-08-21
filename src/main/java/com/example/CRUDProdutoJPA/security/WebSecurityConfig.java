package com.example.CRUDProdutoJPA.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests()
                .antMatchers("/img/**").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/fisica/form/").hasAnyRole("ADMIN")
                .antMatchers("/produtos/form/").hasAnyRole("ADMIN")
                .antMatchers("/").permitAll()
                .antMatchers("/produtos/list").permitAll()
                .antMatchers("/webjars/**").permitAll()//define com as requisições HTTP devem ser tratadas com relação à segurança.
                .anyRequest() //define que a configuração é válida para qualquer requisição.
                .authenticated() //define que o usuário precisa estar autenticado.
                .and()
                .formLogin() //define que a autenticação pode ser feita via formulário de login.
                .loginPage("/login") // passamos como parâmetro a URL para acesso à página de login que criamos
                .permitAll() //define que essa página pode ser acessada por todos, independentemente do usuário estar autenticado ou não.
                .and()
                .logout()
                .permitAll(); 
    }

//    @Autowired
//    public void configureUserDetails(AuthenticationManagerBuilder builder)
//            throws Exception {
//        builder
//                .inMemoryAuthentication()
//                .withUser("admin").password(new BCryptPasswordEncoder().encode("123")).roles("ADMIN"); //user
//    }
}