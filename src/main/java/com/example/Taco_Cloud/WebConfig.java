package com.example.Taco_Cloud;

import com.example.Taco_Cloud.model.User;
import com.example.Taco_Cloud.repository.UserReposiroty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
@EnableGlobalAuthentication
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/login");
    }
    @Bean
    public UserDetailsService userDetailsService(UserReposiroty userReposiroty){
        return username -> {
            User user = userReposiroty.findByUsername(username);
            if(user!=null) return (UserDetailsService) user;

            throw new UsernameNotFoundException(("User "+ username + " not found"));
        };
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .authorizeHttpRequests(
                        (authorizeHttpRequests) -> authorizeHttpRequests
                                .requestMatchers("/design","/orders").hasRole("USER")
                                .requestMatchers("/","/**").permitAll()
                )
                .formLogin((formLogin) -> formLogin.loginPage("/login")
                        .defaultSuccessUrl("/design")
                        .loginProcessingUrl("/authenticate")
                        .usernameParameter("user")
                        .passwordParameter("pwd"))

                .logout((logout)->logout.logoutSuccessUrl("/"))

                .build();
    }

}
