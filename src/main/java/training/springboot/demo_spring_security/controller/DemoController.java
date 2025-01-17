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

    /**
     * Anyone can access this endpoint.
     * @return String
     */
    @GetMapping("/hello")
    public String demo() {
        return "Hello Spring Security !";
    }

    /**
     * Only public can access this endpoint.
     * @return String
     */
    @GetMapping("/public")
    public String publicEndpoint() {
        return "Public Spring Security !";
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
     * Only user can access this endpoint.
     * @return String
     */
    @GetMapping("/user")
    public String user() {
        return "User Spring Security !";
    }

    /**
     * Only authenticated can access this endpoint.
     * @return String
     */
    @GetMapping("/protected")
    public String bye() {
        return "Bye Spring Security !";
    }
}
