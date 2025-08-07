package com.jf.ecommerce.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
//@EnableMethodSecurity
public class SecurityConfig {


  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
      .csrf(csrf -> csrf.ignoringRequestMatchers("/**"))
      //.cors(cors -> cors.configurationSource(corsConfigurationSource()))
      .authorizeHttpRequests((authz) -> authz
        .anyRequest().authenticated()
      )
      .httpBasic(Customizer.withDefaults());
    return http.build();
  }

//  @Bean
//  public CorsConfigurationSource corsConfigurationSource() {
//    CorsConfiguration configuration = new CorsConfiguration();
//    //configuration.setAllowedOrigins(Arrays.asList("http://example.com", "http://another.example.com")); //  Define los orígenes permitidos
//    configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE")); // Define los métodos permitidos
//    configuration.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization")); // Define los encabezados permitidos
//    configuration.setAllowCredentials(true); // Permite el envío de credenciales (cookies, encabezados de autorización)
//    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//    source.registerCorsConfiguration("/**", configuration); // Aplica la configuración a todas las rutas
//    return source;
//  }

//  @Bean
//  public UserDetailsService userDetailsService() {
//    UserDetails user =
//      User.withDefaultPasswordEncoder()
//        .username("juanfer898")
//        .password("pass1234")
//        .roles("USER")
//        .build();
//
//    return new InMemoryUserDetailsManager(user);
//  }

//  @Bean
//  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    http
//      .authorizeHttpRequests((authz) -> authz
//        .requestMatchers("/client/**").permitAll()
//        .requestMatchers("/admin/**").hasRole("ADMIN")
//        .anyRequest().authenticated()
//      )
//      .formLogin(Customizer.withDefaults())
//      .httpBasic(Customizer.withDefaults());
//    return http.build();
//  }

}
