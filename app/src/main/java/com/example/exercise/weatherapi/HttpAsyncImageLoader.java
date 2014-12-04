package com.example.exercise.weatherapi;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Takagi on 2014/12/04.
 */
public class HttpAsyncImageLoader extends AsyncTaskLoader<Bitmap> {

    private String mUrl;

    public HttpAsyncImageLoader(Context context, String url) {
        super(context);
        this.mUrl = url;
    }

    @Override
    public Bitmap loadInBackground() {
        try {
            URL url = new URL(mUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            return BitmapFactory.decodeStream(connection.getInputStream());
        } catch (IOException e) {
            // 404エラーをキャッチ
            e.printStackTrace();
        }

        return null;
    }
}
