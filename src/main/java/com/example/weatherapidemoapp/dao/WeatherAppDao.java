package com.example.weatherapidemoapp.dao;

public interface WeatherAppDao {

    String getWeather(String city);
    Double getTemp(String city);

}
