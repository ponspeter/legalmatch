package com.legalmatch.exam.config;

import com.legalmatch.exam.service.LoginService;
import com.legalmatch.exam.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    // Secure the endpoints with HTTP Basic authentication
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // cors policy
        http.cors().configurationSource(corsConfigurationSource());

        // The pages does not require login
        http.authorizeRequests()
                .antMatchers("/api/v1/auth/**").permitAll()
                .antMatchers(HttpMethod.GET,"/api/v1/employees").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/api/v1/employees").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/api/v1/employees/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH,"/api/v1/employees/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/api/v1/employees/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/api/v1/employees/**").hasAnyRole("ADMIN", "STANDARD_USER")
                .antMatchers(HttpMethod.DELETE,"/api/v1/employees/search/**").hasRole("STANDARD_USER")
                    .anyRequest()
                        .authenticated()
                .and()
                    .logout()
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutSuccessUrl("/login?logout")
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                .and()
                    .csrf()
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()
                    .exceptionHandling()
                        .accessDeniedPage("/403")
                .and()
                    .httpBasic()
                .and()
                    .csrf()
                        .disable();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","PATCH","DELETE"));
        configuration.setAllowCredentials(true);
        configuration.addAllowedOrigin("*");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
