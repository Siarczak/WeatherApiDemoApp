package com.example.weatherapidemoapp.service;

import com.example.weatherapidemoapp.api.WeatherApi;
import com.example.weatherapidemoapp.dao.WeatherAppDao;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class WeatherService implements WeatherAppDao {


    private final String apiKey = "b9723ee1e5644cb925dd31f0e4f408cc";


    public WeatherService() {

    }

    @Override
    public String getWeather(String city) {

        RestTemplate restTemplate = new RestTemplate();
        WeatherApi weatherJson2Pojo = restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q=" + "London" + "&appid=" + apiKey, WeatherApi.class);


        return weatherJson2Pojo.toString();

    }


    @Override
    public Double getTemp(String city) {

        RestTemplate restTemplate = new RestTemplate();
        WeatherApi weatherJson2Pojo = restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q=" + "London"+ "&appid=" + apiKey, WeatherApi.class);
        BigDecimal kelvinTempToConvert = BigDecimal.valueOf(weatherJson2Pojo.getMain().getTemp());
        BigDecimal kelvinDifference = BigDecimal.valueOf(273.15);

        BigDecimal convertKelvinToCelcius = kelvinTempToConvert.subtract(kelvinDifference);

        return convertKelvinToCelcius.doubleValue();

    }

    public final String getInitialCity()
    {

        return "London";
    }



}
