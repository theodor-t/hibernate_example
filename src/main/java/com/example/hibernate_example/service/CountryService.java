package com.example.hibernate_example.service;

import com.example.hibernate_example.model.Country;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface CountryService {

    Country save(Country country);
    List<Country> getAll();
    Country get(long id);
    Country update(Country country, long id );
}
