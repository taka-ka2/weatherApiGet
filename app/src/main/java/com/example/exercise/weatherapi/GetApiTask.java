package com.example.exercise.weatherapi;

import android.content.Context;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Takagi on 2014/12/01.
 */
public class GetApiTask extends AsyncTask<String, Void, String> {

    // JSON形式基本URL
    private static final String URL = "http://weather.livedoor.com/forecast/webservice/json/v1?city=";
    private static final String USER_AGENT = "WeatherForecasts";

    WeatherDisplayActivity activity;

//    private final Context context;
    Exception exception;

    public GetApiTask(WeatherDisplayActivity activity){
//        this.context = context;
        this.activity = activity;
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            AndroidHttpClient client = AndroidHttpClient.newInstance(USER_AGENT);
            HttpGet get = new HttpGet(URL + strings[0]);
            StringBuilder sb = new StringBuilder();

            HttpResponse response = client.execute(get);
            BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();

//            return WeatherApi.getWeather(context, params[0]);
        } catch (Exception e) {
            exception = e;
//        } catch (JSONException e) {
//            exception = e;
        }
        return null;
//        return new WeatherForecast(new JSONObject(sb.toString()));
    }

    @Override
    protected void onPostExecute(String result) {
        // 画面に文字列を表示
//        text.setText(result);
        try {
            activity.SetDate(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
