package com.example.tourism.model;

public class City {
    private int CityID;
    private String CityName;

    public City(){}

    public City(int CityID, String CityName) {
        this.CityID = CityID;
        this.CityName = CityName;

    }

    public int getCityID() {
        return CityID;
    }
    public void setCityID(int cityID) {
        this.CityID = cityID;
    }

    public String getCityName() {
        return CityName;
    }
    public void setCityName(String cityName) {
        this.CityName = cityName;
    }

    @Override
    public String toString() {
        return "City{CityID=" + CityID + ", CityName='" + CityName  + "}";
    }


}
