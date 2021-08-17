package com.example.weatherapidemoapp.service;

import com.example.weatherapidemoapp.api.WeatherApi;
import com.example.weatherapidemoapp.dao.WeatherAppDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Controller
public class WeatherController implements WeatherAppDao {


    private final String apiKey = "b9723ee1e5644cb925dd31f0e4f408cc";
    private String city = "london";

    public WeatherController() {
        getWeather(city);
    }

    @Override
    public String getWeather(String city) {

        RestTemplate restTemplate = new RestTemplate();
        WeatherApi weatherJson2Pojo = restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey, WeatherApi.class);


        return weatherJson2Pojo.toString();

    }


    @Override
    public Double getTemp(String city) {

        RestTemplate restTemplate = new RestTemplate();
        WeatherApi weatherJson2Pojo = restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey, WeatherApi.class);
        BigDecimal kelvinTempToConvert = BigDecimal.valueOf(weatherJson2Pojo.getMain().getTemp());
        BigDecimal kelvinDifference = BigDecimal.valueOf(273.15);

        BigDecimal convertKelvinToCelcius = kelvinTempToConvert.subtract(kelvinDifference);

        return convertKelvinToCelcius.doubleValue();

    }

    @GetMapping("/welcome")
    public String getWeatherForCity(Model model) {

        model.addAttribute("city", new WeatherApi());


        return "welcome";
    }

    @GetMapping("/error")
    public String incorrectUserInput(Model model) {


        return "error";
    }


    @PostMapping("/welcome")
    public String getCityWeatherByInput(@ModelAttribute WeatherApi weatherApi, Model model) throws HttpClientErrorException {
        String cityName = weatherApi.getName();


        model.addAttribute("city", getWeather(cityName));
        model.addAttribute("temeperature", getTemp(cityName));
        model.addAttribute("cityName", cityName);
        return "weather";


    }


}
