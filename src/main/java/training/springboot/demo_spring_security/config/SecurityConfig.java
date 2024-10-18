package training.springboot.demo_spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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

    /**
     * L'`AuthenticationFilter` délègue la responsabilité de l'authentification à un
     * `AuthenticationManager`. Il utilise un `AuthenticationProvider` pour authentifier
     * l'utilisateur.
     * L'`AuthenticationManager` est responsable de gérer les détails
     * de connexion de l'utilisateur, telles que les autorisations, les rôles et les
     * attributs supplémentaires.
     */

    /**
     * Cette méthode permet de définir les utilisateurs et leurs rôles.
     *
     * @return ces utilisateurs construis dans InMemoryUserDetailsManager
     * @see InMemoryUserDetailsManager
     */
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.builder()
                .username("user")
                .password("user")
                .roles("ROLE_USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password("admin")
                .roles("ROLE_ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    /**
     * L'AuthenticationManager utilise un PasswordEncoder pour encoder les mots de passe
     * des utilisateurs. Donc il faut le créer.
     * @see PasswordEncoder
     * @return le mot de passe encodé.
     */

    /**
     * Cette méthode permet de définir le mot de passe encodé.
     *
     * @return le mot de passe encodé.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}




















