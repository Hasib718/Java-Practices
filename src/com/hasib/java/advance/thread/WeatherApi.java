package com.hasib.java.advance.thread;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

/*
 * Created by S M Al Hasib on 7/23/20, 11:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 7/23/20, 11:42 PM
 */

public class WeatherApi {
    public static void main(String[] args) {
        String cityName = "Dhaka";
        String API = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=d99dd4dc1cfb79da396e3518073c3aec";
        String output = "";

        DownloadingTask downloadingTask = new DownloadingTask(API);
        Thread thread = new Thread(downloadingTask);
        thread.setName("Weather Api Download task");
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        output = downloadingTask.getOutput();
        System.out.println(output);

        JSONObject jsonObject, mainObject;
        try {
            jsonObject = new JSONObject(output);
            JSONArray weather = jsonObject.getJSONArray("weather");

            System.out.println(weather.get(0).toString());

            Map weatherMap = (Map) weather.get(0);
            Iterator<Map.Entry> iterator = weatherMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry pair = iterator.next();
                System.out.println(pair.getKey()+" : "+pair.getValue());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

class DownloadingTask implements Runnable {
    private String API;

    private URL url;
    private HttpURLConnection urlConnection;
    private String output = "";

    private volatile boolean isWorking = true;

    public DownloadingTask(String API) {
        this.API = API;
    }

    @Override
    public void run() {
        output = DownloadingWebContent();
    }

    private String DownloadingWebContent() {
        String ret = "";

        try {
            url = new URL(API);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);

            int n;
            while ((n = reader.read()) != -1) {
                ret += (char) n;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ret;
    }

    public String getOutput() {
        return output;
    }
}
