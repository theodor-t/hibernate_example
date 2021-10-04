package com.example.hibernate_example.service.impl;

import com.example.hibernate_example.exception.ResourceNotFoundException;
import com.example.hibernate_example.model.City;
import com.example.hibernate_example.model.Country;
import com.example.hibernate_example.repository.CityRepository;
import com.example.hibernate_example.repository.CountryRepository;
import com.example.hibernate_example.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    CityRepository cityRepository;
    CountryRepository countryRepository;

    public CityServiceImpl(CityRepository cityRepository, CountryRepository countryRepository){
        super();
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public List<Country> getAll() {
        return countryRepository.findCountriesByCities_NotEmpty();
    }

    @Override
    public City get(long id) {
        return cityRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("City", "id", id));
    }
    @Override
    public City update(City city, long id) {
        City existingCity = cityRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("City", "id", id));
        existingCity.setName(city.getName());
        cityRepository.save(existingCity);
        return existingCity;

    }
    @Override
    public void delete(long id) {
        cityRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Country","id",id));
        cityRepository.deleteById(id);
    }
}
