package org.ltde.glowboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CallbackController {

    @GetMapping("/callback")
    public String handleCallback(@RequestParam String code, @RequestParam String state) {
        // Process the code and state
        // Exchange code for token, etc.
        return "redirect:/home"; // Redirect to another page after processing
    }
}
