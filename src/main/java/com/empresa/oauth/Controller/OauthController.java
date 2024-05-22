package com.empresa.oauth.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/oauth")
public class OauthController {

    @GetMapping("/secured")
    public Map<String, Object> secured(Authentication authentication) {
        Map<String, Object> userDetails = new HashMap<>();
        userDetails.put("username", authentication.getName());
        userDetails.put("authorities", authentication.getAuthorities());
        userDetails.put("authenticated", authentication.isAuthenticated());
        userDetails.put("details", authentication.getDetails());
        return userDetails;
    }

    @GetMapping("/not-secured")
    public String notSecured() {
        return "Not Secured";
    }

    @GetMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("message", "Ya puede volver a la aplicación");
        return "welcome";
    }
}
