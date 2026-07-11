package com.cognizant.greet.controller;
import org.springframework.web.bind.annotation.*;import java.util.Map;
@RestController public class GreetServiceController { @GetMapping("/greet") public Map<String,String> greet(){ return Map.of("message","Hello World"); }}