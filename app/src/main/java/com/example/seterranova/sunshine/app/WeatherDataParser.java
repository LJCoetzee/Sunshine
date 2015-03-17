package com.example.seterranova.sunshine.app;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherDataParser
{

    /**
     * Given a string of the form returned by the api call:
     * http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7
     * retrieve the maximum temperature for the day indicated by dayIndex
     * (Note: 0-indexed, so 0 would refer to the first day).
     */
    public static double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex)
            throws JSONException
    {
        // TODO: add parsing code here

        /*
        String rawJson = weatherJsonStr;

        long epoch = Math.round(new Date().getTime()/1000.0);
        System.out.println("---> " + epoch);
        System.out.println("--------------");


        //System.out.println(rawJson);
        //System.out.println("--------------");

        int epochDateStartIndex = rawJson.indexOf("dt");

        long jsonDate = Long.parseLong(rawJson.substring(epochDateStartIndex+3,rawJson.indexOf("dt",epochDateStartIndex)));

        System.out.println("---> " + jsonDate);

        int index = 0;
        */
        double max = 0.0;
        try
        {
            JSONObject jsonStr = new JSONObject(weatherJsonStr);
            JSONArray list = jsonStr.getJSONArray("list");

            JSONObject temp = list.getJSONObject(dayIndex).getJSONObject("temp");
            max = temp.getDouble("max");

        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        finally
        {
            return max;
        }
    }

}
