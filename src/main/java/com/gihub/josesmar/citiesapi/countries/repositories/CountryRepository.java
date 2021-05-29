package com.gihub.josesmar.citiesapi.countries.repositories;

import com.gihub.josesmar.citiesapi.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}