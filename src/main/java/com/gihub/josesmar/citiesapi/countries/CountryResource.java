package com.gihub.josesmar.citiesapi.countries;

import com.gihub.josesmar.citiesapi.countries.Country;
import com.gihub.josesmar.citiesapi.countries.repositories.CountryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CountryResource {

    private final CountryRepository repository;

    public CountryResource(final CountryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/countries")
    public List<Country> cities() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getOne(@PathVariable Long id){
        Optional<Country>optional = repository.findById(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok().body(optional.get());
        }else {
            return ResponseEntity.notFound().build();

        }

    }
}