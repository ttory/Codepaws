package ru.weather;

import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class WeatherServiceImpl implements WeatherService {

    private  CurrentWeather _currentWeather;


    public WeatherServiceImpl () throws IOException, JSONException, APIException {

        OWM owm = new OWM("01b5f54b9605d5bbae6cf9f831560fb5");

        CurrentWeather forecast = owm.currentWeatherByCityName("Saint Peterburg", OWM.Country.RUSSIA);

    }


    public static void main(String[] args) throws IOException,JSONException, APIException {
        WeatherServiceImpl p = new WeatherServiceImpl();

        System.out.print(p.getTemperatureInCelsius());
        System.out.println(p.getDate());

    }

        @Override
        public double getTemperatureInCelsius ()
        {
            double KfTemp = _currentWeather.getMainData().getTemp();
            return (KfTemp - 273.15);
        }

        @Override
        public double getDate () {
            double time = _currentWeather.getDateTime().getTime();
            return time;
        }



}
