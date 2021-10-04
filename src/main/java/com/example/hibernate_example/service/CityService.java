package com.example.hibernate_example.service;

import com.example.hibernate_example.model.City;
import com.example.hibernate_example.model.Country;

import java.util.List;

public interface CityService {
    City save(City country);
    List<Country> getAll();
    City get(long id);
    City update(City city, long id );
    void delete(long id);
}
