package com.cognizant.springrest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import java.util.Arrays;
import java.util.List;

@RestController
public class CountryController {
    private final List<Country> countries = Arrays.asList(
            new Country("IN", "India"),
            new Country("US", "United States"),
            new Country("JP", "Japan")
    );

    @GetMapping("/countries/{code}")
    public Country getCountryByCode(@PathVariable String code) {
        return countries.stream()
                .filter(country -> country.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Country not found"));
    }
}
