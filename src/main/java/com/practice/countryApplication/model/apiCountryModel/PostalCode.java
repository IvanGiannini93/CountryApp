package com.practice.countryApplication.model.apiCountryModel;

import java.io.Serializable;

public class PostalCode implements Serializable {
    private String format;
    private String regex;

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }
}
