package com.practice.countryApplication.restTemplate.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.countryApplication.model.apiCountryModel.Country;
import com.practice.countryApplication.model.modelDTO.CountryDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

@Component
public class CountryApiService {
    Logger logger = Logger.getLogger("CountryApiService");

    private static final String url = "https://restcountries.com/v3.1";

    public Country getCountryByName(String nameCountry) throws IOException {
        Country country = null;
        ObjectMapper objectMapper = new ObjectMapper();
        URL urlAPI = new URL(url + "/name/" + nameCountry);
        HttpURLConnection connection = (HttpURLConnection) urlAPI.openConnection();

        if (connection != null) {
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                logger.info("'GET' Request is Succeeded Http Status Code: " + responseCode);

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = bufferedReader.readLine()) != null) {
                    response.append(inputLine);
                }
                bufferedReader.close();
                country = objectMapper.readValue(response.toString(), Country[].class)[0];
            }
        }
        return country;
    }

    public List<Country> getCountriesByRegion(String regionName){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Country[]> response = restTemplate.getForEntity(url + "/region/" + regionName, Country[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

}
