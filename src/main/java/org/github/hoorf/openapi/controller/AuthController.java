package org.github.hoorf.openapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {
    
    @GetMapping("/getAccessToken")
    public Map<String,String> getAccessToken(){
        Map<String,String> result = new HashMap<>();
        
        return result;
    }
}
