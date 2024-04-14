package com.practice.countryApplication.service.impl;

import com.practice.countryApplication.model.apiCountryModel.Country;
import com.practice.countryApplication.model.modelDTO.CountryDTO;
import com.practice.countryApplication.restTemplate.web.CountryApiService;
import com.practice.countryApplication.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements ICountryService {
    @Autowired
    private CountryApiService template;

    @Override
    public CountryDTO findCountryByName(String countryName) {
        Country country = null;
        CountryDTO countryDTO = null;
        try{
            country = this.template.getCountryByName(countryName);
            countryDTO = new CountryDTO(country);
        } catch (Exception e){
            e.printStackTrace();
        }
        return countryDTO;
    }

    @Override
    public List<String> getCountriesByRegion(String regionName) {
        List<String> countries = null;
        try{
            countries = template.getCountriesByRegion(regionName).stream().map(country -> country.getName().getCommon()).collect(Collectors.toList());
        } catch (Exception e){
            e.printStackTrace();
        }
        return countries;
    }
}
