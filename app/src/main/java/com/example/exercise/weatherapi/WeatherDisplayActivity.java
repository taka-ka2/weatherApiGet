package com.example.exercise.weatherapi;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Takagi on 2014/11/30.
 */
public class WeatherDisplayActivity extends Activity {

    private TextView myLabel;
    private ListView listView;
    GetApiTask getApiTask = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_display);

        Intent intent = getIntent();
        String myName = intent.getStringExtra(MainActivity.EXTRA_MYNAME);
//        myLabel = (TextView) findViewById(R.id.textViewResult);
        listView = (ListView) findViewById(R.id.listViewResult);
        List<String> list = new ArrayList<String>();
//        myLabel.setText(myName);

        // API取得
        getApiTask = new GetApiTask(this);
        getApiTask.execute(myName);

    }

    public void SetDate(String result) throws JSONException {

        ArrayAdapter<String> adapter;
        String date, telop, dateLabel, url;
//        Image image;

        // JSONオブジェクト生成
        JSONObject rootObject = new JSONObject(result);
        JSONArray itemArray = rootObject.getJSONArray("forecasts");

        // リストビュー用のアダプター宣言
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        //
//        class Image {
//            String url;
//            public Image(JSONObject jsonObject) throws JSONException {
//                url = jsonObject.getString("url");
//            }
//        }

        // 取得アイテム分アダプターに設定
        for (int i = 0; i < itemArray.length(); i++) {
            JSONObject jsonObject = itemArray.getJSONObject(i);
            date = jsonObject.getString("date");
            telop = jsonObject.getString("telop");
            dateLabel = jsonObject.getString("dateLabel");

            url = jsonObject.getJSONObject("image").getString("url");
//            url = jsonObject.getString("image");

            adapter.add(date + " ( " + dateLabel + " ) " + telop + " " + url);
        }

        // アダプターを設定します
        listView.setAdapter(adapter);

    }

}
