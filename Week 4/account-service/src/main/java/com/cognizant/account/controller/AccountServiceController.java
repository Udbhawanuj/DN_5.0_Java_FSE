package com.cognizant.account.controller;
import org.springframework.web.bind.annotation.*;import java.math.BigDecimal;import java.util.Map;
@RestController public class AccountServiceController { @GetMapping("/accounts/{number}") public Map<String,Object> get(@PathVariable String number){ return Map.of("number",number,"type","savings","balance",new BigDecimal("234343")); }}