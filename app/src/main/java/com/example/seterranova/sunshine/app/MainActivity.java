package com.example.seterranova.sunshine.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {

    private final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new ForecastFragment())
                    .commit();
        }

        //Log.d(LOG_TAG, "Created");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        //getMenuInflater().inflate(R.menu.forecastfragment, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }

        if (id == R.id.action_map) {
            openPreferredLocationInMap();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //helper method for allowing the user to choose the preferred location on a map
    private void openPreferredLocationInMap()
    {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Store the location preference in a string "location" by passing the
        String location = prefs.getString(getString(R.string.pref_location_key),//key stored in the the string.xml file
                getString(R.string.pref_location_default));

        Uri geoLocation = Uri.parse("geo:0,0?").buildUpon()
                .appendQueryParameter("q", location)
                .build();

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);

        if (intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        }
        else
        {
            Log.d(LOG_TAG, "Couldn't call " + location + ", no receiving apps installed!");
        }
    }

    /*
    @Override
    protected void onPause()
    {
        Log.d(LOG_TAG, "Paused");
    }
    @Override
    protected void onStop()
    {
        Log.d(LOG_TAG, "Stopped");
    }
    @Override
    protected void onResume()
    {
        Log.d(LOG_TAG, "Resumed");
    }
    @Override
    protected void onStart()
    {
        Log.d(LOG_TAG, "Started");
    }
    @Override
    protected void onDestroy()
    {
        Log.d(LOG_TAG, "Destroyed");
    }
    */
}