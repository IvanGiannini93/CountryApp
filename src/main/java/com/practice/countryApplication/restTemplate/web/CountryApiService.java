package com.practice.countryApplication.restTemplate.web;

import com.practice.countryApplication.model.apiCountryModel.Country;
import com.practice.countryApplication.model.modelDTO.CountryDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class CountryApiService {

    private static final String url = "https://restcountries.com/v3.1";

    public Country getCountryByName(String nameCountry){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Country[]> response = restTemplate.getForEntity(url + "/name/" + nameCountry, Country[].class);
        Country country = new Country();
        CountryDTO countryDTO = new CountryDTO();
        country = Objects.requireNonNull(response.getBody())[0];
        return country;
    }

    public List<Country> getCountriesByRegion(String regionName){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Country[]> response = restTemplate.getForEntity(url + "/region/" + regionName, Country[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

}
