package ru.weather;

import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
@Service
public class WeatherServiceImpl implements WeatherService {

    private  CurrentWeather _currentWeather;
    @Value("${owm.apikey}")
    private String apikey;


    @PostConstruct
    public void  WeatherServiceImpl () throws IOException, JSONException  {

        OWM owm = new OWM(apikey);

        try {
            CurrentWeather forecast = owm.currentWeatherByCityName("Saint Peterburg", OWM.Country.RUSSIA);
        } catch (APIException e) {
            e.printStackTrace();
        }

    }


   /* public static void main(String[] args) throws IOException,JSONException {
        WeatherServiceImpl p = new WeatherServiceImpl();

        System.out.print(p.getTemperatureInCelsius());
        System.out.println(p.getDate());

    }*/

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
