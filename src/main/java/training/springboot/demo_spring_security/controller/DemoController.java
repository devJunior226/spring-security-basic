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
}
