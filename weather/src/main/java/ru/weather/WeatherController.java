package ru.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WeatherController{

    @Autowired
        private WeatherService weatherService;

    @RequestMapping("/")
    public String Ok() { return "ok";}

    /*TODO: add temp page normally*/
    @RequestMapping("/temp")
    public double check() {
        double temp = weatherService.getTemperatureInCelsius();
        return temp;
    }


}
