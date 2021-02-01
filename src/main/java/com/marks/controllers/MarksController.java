package com.marks.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarksController {
    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
