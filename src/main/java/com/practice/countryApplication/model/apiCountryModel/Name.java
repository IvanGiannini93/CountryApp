package com.practice.countryApplication.model.apiCountryModel;

import java.util.Map;

public class Name {
    private String common;
    private String official;
    private Map<String, NameNative> nativeName;

    public String getCommon() {
        return common;
    }

    public void setCommon(String common) {
        this.common = common;
    }

    public String getOfficial() {
        return official;
    }

    public void setOfficial(String official) {
        this.official = official;
    }

    public Map<String, NameNative> getNativeName() {
        return nativeName;
    }

    public void setNativeName(Map<String, NameNative> nativeName) {
        this.nativeName = nativeName;
    }
}
