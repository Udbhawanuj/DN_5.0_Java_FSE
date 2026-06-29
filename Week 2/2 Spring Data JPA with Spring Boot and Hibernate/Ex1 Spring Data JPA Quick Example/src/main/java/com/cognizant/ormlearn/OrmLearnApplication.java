package com.cognizant.ormlearn;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;
@SpringBootApplication
public class OrmLearnApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }
    @Bean
    public CommandLineRunner demo(CountryService countryService) {
        return args -> {
            countryService.addCountry(new Country("IN", "India"));
            countryService.addCountry(new Country("US", "United States"));
            countryService.addCountry(new Country("JP", "Japan"));
            System.out.println("Spring Data JPA example started successfully.");
            System.out.println("Countries saved successfully.");
            List<Country> countries = countryService.getAllCountries();
            System.out.println("All countries:");
            countries.forEach(System.out::println);
            Country selectedCountry = countryService.findCountryByCode("IN");
            System.out.println("Country found by code IN: " + selectedCountry);
        };
    }
}
