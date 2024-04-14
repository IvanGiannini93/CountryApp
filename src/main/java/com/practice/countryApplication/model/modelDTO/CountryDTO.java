package com.practice.countryApplication.model.modelDTO;

import com.practice.countryApplication.model.apiCountryModel.Country;
import com.practice.countryApplication.model.apiCountryModel.Currency;

import java.util.List;
import java.util.Map;

public class CountryDTO {

    private String name;
    private List<String> capitals;
    private Integer population;
    private Double area;
    private Map<String, String> officialLanguages;
    private Map<String, Currency> currencies;

    public CountryDTO() {
    }

    public CountryDTO(Country country) {
        this.name = country.getName().getOfficial();
        this.capitals = country.getCapital();
        this.population = country.getPopulation();
        this.area = country.getArea();
        this.officialLanguages = country.getLanguages();
        this.currencies = country.getCurrencies();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCapitals() {
        return capitals;
    }

    public void setCapitals(List<String> capitals) {
        this.capitals = capitals;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Map<String, String> getOfficialLanguages() {
        return officialLanguages;
    }

    public void setOfficialLanguages(Map<String, String> officialLanguages) {
        this.officialLanguages = officialLanguages;
    }

    public Map<String, Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Map<String, Currency> currencies) {
        this.currencies = currencies;
    }
}
