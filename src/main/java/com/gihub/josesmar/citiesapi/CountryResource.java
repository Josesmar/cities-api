package com.gihub.josesmar.citiesapi;

import com.gihub.josesmar.citiesapi.countries.Country;
import com.gihub.josesmar.citiesapi.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;

@RestController
@RequestMapping
public class CountryResource {

@Autowired
    private CountryRepository repository;

    public CountryResource(CountryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/countries")
    public Page<Country> countries(Pageable page) {
        return repository.findAll((org.springframework.data.domain.Pageable) page);
    }
}