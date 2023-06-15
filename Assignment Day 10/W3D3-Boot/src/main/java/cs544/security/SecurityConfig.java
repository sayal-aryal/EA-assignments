package cs544.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
            User.builder()
                .username("user")
                .password(passwordEncoder().encode("pass"))
                .roles("USER")
                .build(),
            User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build()
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests ->{
            try {
                requests
                        .requestMatchers(HttpMethod.GET, "/cars").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/cars").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/cars/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                        .and()
                        .formLogin(withDefaults())
                        .logout(logout -> logout.permitAll());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
  
    
}
