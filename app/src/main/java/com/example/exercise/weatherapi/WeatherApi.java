package com.example.exercise.weatherapi;

import android.content.Context;
import android.net.http.AndroidHttpClient;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Takagi on 2014/12/01.
 */
public class WeatherApi {

    // インスタンス名
    private static final String USER_AGENT = "WeatherForecasts";
    // JSON形式基本URL
    private static final String URL = "http://weather.livedoor.com/forecast/webservice/json/v1?city=";

/*
    public static WeatherForecast getWeather(Context context, String pointId) throws IOException, JSONException {

        AndroidHttpClient client = AndroidHttpClient.newInstance(USER_AGENT, context);
        HttpGet get = new HttpGet(URL + pointId);
        StringBuilder sb = new StringBuilder();

        try {
            HttpResponse response = client.execute(get);
            BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }


        } finally {
            client.close();
        }

    }
   */
}
