package com.practice.countryApplication.restTemplate.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.countryApplication.model.apiCountryModel.Country;
import com.practice.countryApplication.model.modelDTO.CountryDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class CountryApiService {

    private static final String url = "https://restcountries.com/v3.1";

    public Country getCountryByName(String nameCountry) throws IOException, InterruptedException {
        Country country = null;
        ObjectMapper objectMapper = new ObjectMapper();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + "/name/" + nameCountry))
                .build();
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        country = objectMapper.readValue(response.body(), Country[].class)[0];
        return country;
    }

    public List<Country> getCountriesByRegion(String regionName){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Country[]> response = restTemplate.getForEntity(url + "/region/" + regionName, Country[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

}
