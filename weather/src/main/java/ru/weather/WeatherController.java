package ru.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WeatherController{
    @Autowired
            WeatherService weatherService;

    @RequestMapping("/")
    public String check() {
        return "OK";
    }

    @RequestMapping(value = "/info")
    public ResponseEntity<Object> getTemp(){
        return new ResponseEntity<>(weatherService.getTemperatureInCelsius(), HttpStatus.OK);
    }
}
