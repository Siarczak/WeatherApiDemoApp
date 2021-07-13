
package com.example.weatherapidemoapp.Clinet;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "temperature",
        "wind",
        "description",
        "forecast"
})
@Generated("jsonschema2pojo")
public class WeatherJson2Pojo {


    @JsonProperty("temperature")
    private String temperature;
    @JsonProperty("wind")
    private String wind;
    @JsonProperty("description")
    private String description;
    @JsonProperty("forecast")
    private List<ForecastJson2Pojo> forecastJson2Pojo = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    @JsonProperty("temperature")
    public String getTemperature() {
        return temperature;
    }

    @JsonProperty("temperature")
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @JsonProperty("wind")
    public String getWind() {
        return wind;
    }

    @JsonProperty("wind")
    public void setWind(String wind) {
        this.wind = wind;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("forecast")
    public List<ForecastJson2Pojo> getForecast() {
        return forecastJson2Pojo;
    }

    @JsonProperty("forecast")
    public void setForecast(List<ForecastJson2Pojo> forecastJson2Pojo) {
        this.forecastJson2Pojo = forecastJson2Pojo;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "WeatherJson2Pojo{" +
                "temperature='" + temperature + '\'' +
                ", wind='" + wind + '\'' +
                ", description='" + description + '\'' +
                ", forecastJson2Pojo=" + forecastJson2Pojo +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
