package training.springboot.demo_spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Author: Juldas RAMDE
 * Since: 17/10/2024 at 23:33
 */
@Configuration
public class SecurityConfig {

    /*
     * This is a simple configuration class that defines a security filter chain
     * for the application. The filter chain is used to define which requests
     * require authentication and which requests are permitted without authentication.
     *
     * In this case, the filter chain is configured to require authentication for
     * the /api/hello endpoint and permit all other requests without authentication.
     *
     * The httpBasic() method is used to enable HTTP Basic authentication, which
     * is a simple authentication mechanism where the client sends the username
     * and password with each request.
     */

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                        auth -> auth
                                .requestMatchers("/api/hello").authenticated()
                                .anyRequest().permitAll()
                )
                .httpBasic();
        return http.build();
    }
}




















