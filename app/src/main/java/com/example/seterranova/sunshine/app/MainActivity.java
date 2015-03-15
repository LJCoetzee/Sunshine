package com.example.seterranova.sunshine.app;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            ArrayList<String> forecastData = new ArrayList<>();

            forecastData.add("Today - Sunny - 30/15");
            forecastData.add("Tomorrow - Partly Sunny - 30/15");
            forecastData.add("Tuesday - Sunny - 30/16");
            forecastData.add("Wednesday - Rainy - 29/16");
            forecastData.add("Thursday - Rainy - 27/15");
            forecastData.add("Friday - Partly Cloudy - 29/14");
            forecastData.add("Saturday - Rainy - 27/14");

            //ArrayAdapter<String> adapter = new ArrayAdapter<String>(Context,, , list of data);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    getActivity(),                      //Current context -> This fragment's parent activity
                    R.layout.list_item_forecast,        //ID of list item layout
                    R.id.list_item_forecast_textView,   //ID of text view
                    forecastData);                      //Forecast list data

            //FrameLayout frameLayout = (FrameLayout).this.findViewById(R.id.)
            ListView listView = (ListView)rootView.findViewById(R.id.listView_forecast);
            listView.setAdapter(adapter);

            return rootView;
        }
    }
}
