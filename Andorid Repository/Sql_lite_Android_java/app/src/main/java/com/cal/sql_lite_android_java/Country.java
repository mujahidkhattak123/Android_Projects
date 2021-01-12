package com.cal.sql_lite_android_java;

public class Country {
    public Country() {

    }

    public int getId() {
        return id;
    }

    public Country(int id, String countryName, long population) {
        this.id = id;
        this.countryName = countryName;
        this.population = population;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    int id;
    String countryName;
    long population;
}
