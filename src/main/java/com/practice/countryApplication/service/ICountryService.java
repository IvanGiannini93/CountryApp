package com.practice.countryApplication.service;

import com.practice.countryApplication.model.apiCountryModel.Country;
import com.practice.countryApplication.model.modelDTO.CountryDTO;

import java.util.List;

public interface ICountryService {
    public CountryDTO findCountryByName(String countryName);

    public List<String> getCountriesByRegion(String regionName);
}
