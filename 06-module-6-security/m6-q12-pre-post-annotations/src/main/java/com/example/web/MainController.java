package com.example.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class MainController {

    private static final Logger log = LoggerFactory.getLogger(MainController.class);
    @GetMapping("/")
    @PreAuthorize("false")
    public String index() {
        log.info("index method done.");
        return "This is index page";
    }

    @GetMapping("/post")
    @PostAuthorize("false")
    public String post() {
        log.info("post method done.");
        return "This is post page";
    }

    @GetMapping("/pre/{id}")
    @PreAuthorize("#id.equals('secret_param')")
    public String preWithId(@PathVariable("id") String id) {
        log.info("pre with id method done.");
        return "This is pre page with id: " + id;
    }
}
