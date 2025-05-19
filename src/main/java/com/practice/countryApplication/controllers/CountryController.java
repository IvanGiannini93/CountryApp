package com.practice.countryApplication.controllers;

import com.practice.countryApplication.model.apiCountryModel.Country;
import com.practice.countryApplication.model.modelDTO.CountryDTO;
import com.practice.countryApplication.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/country")
public class CountryController {
    Logger logger = Logger.getLogger("CountryController");
    @Autowired
    private ICountryService countryService;

     @SuppressWarnings("CallToPrintStackTrace")
   /*  @GetMapping("/name/{nameCountry}")
    public CountryDTO getCountryByName(@PathVariable String nameCountry){
         CountryDTO response = null;
         try{
             response = countryService.findCountryByName(nameCountry);
         } catch(Exception e){
             e.printStackTrace();
         }
         return response;
     }*/

    @GetMapping("/name/{nameCountry}")
    public CountryDTO getCountryByName(@PathVariable String nameCountry) throws IOException {
        CountryDTO response = null;
        response = countryService.findCountryByName(nameCountry);
      return response;
    }

     @GetMapping("/region/{regionName}")
    public List<String> getCountriesByRegion(@PathVariable String regionName){
         List<String> countries = null;
         try {
             countries = countryService.getCountriesByRegion(regionName);
         } catch (Exception e){
             e.printStackTrace();
         }
         return countries;
     }

     @GetMapping("/language/countryName")
    public Map<String, Double> getLanguagesCountry(@PathVariable String countryName){
        return null;
     }
}
