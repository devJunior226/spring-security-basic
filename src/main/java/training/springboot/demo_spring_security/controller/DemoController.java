package training.springboot.demo_spring_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Juldas RAMDE
 * Since: 17/10/2024 at 21:58
 */

@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/hello")
    public String demo() {
        return "Hello Spring Security !";
    }

    @GetMapping("/bye")
    public String bye() {
        return "Bye Spring Security !";
    }

    /**
     * Only admin can access this endpoint.
     * @return String
     */
    @GetMapping("/admin")
    public String admin() {
        return "Admin Spring Security !";
    }

    /**
     * Only user and admin can access this endpoint.
     * @return String
     */
    @GetMapping("/user")
    public String user() {
        return "User Spring Security !";
    }

    /**
     * Anyone can access this endpoint.
     * @return String
     */
    @GetMapping("/public")
    public String publicEndpoint() {
        return "Public Spring Security !";
    }
}
