package com.example.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String index() {
        return "this is index";
    }

    @GetMapping("/deny")
    public String deny() {
        return "This is deny page";
    }

    @GetMapping("/some-page")
    public String somePage() {
        return "This is some page";
    }

}
