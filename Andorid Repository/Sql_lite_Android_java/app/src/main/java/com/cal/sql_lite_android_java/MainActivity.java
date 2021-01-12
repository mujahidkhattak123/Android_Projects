package com.cal.sql_lite_android_java;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Country> countries;
    sqlLite_ db;
    Button btnSubmit;
    PopupWindow pwindo;
    Activity activity;
    ListView listView;
    mYAdapter customCountryList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db= new sqlLite_(this);
        listView = (ListView) findViewById(android.R.id.list);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPopUp();
            }
        });
        Log.d("MainActivity: ", "Before reading mainactivity");
        countries = (ArrayList) db.getAllCountry();

        for (Country country : countries) {
            String log = "Id: " + country.getId() + " ,Name: " + country.getCountryName() + " ,Population: " + country.getPopulation();
            // Writing Countries to log
            Log.d("Name: ", log);
        }


        mYAdapter customCountryList = new mYAdapter(this, countries, db);
        listView.setAdapter(customCountryList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getApplicationContext(), "You Selected " + countries.get(position).getCountryName() + " as Country", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void addPopUp() {
        LayoutInflater inflater = activity.getLayoutInflater();
        View layout = inflater.inflate(R.layout.edit_popup,
                (ViewGroup) activity.findViewById(R.id.popup_element));
        pwindo = new PopupWindow(layout, 600, 670, true);
        pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
        final EditText countryEdit = (EditText) layout.findViewById(R.id.editTextCountry);
        final EditText populationEdit = (EditText) layout.findViewById(R.id.editTextPopulation);

        Button save = (Button) layout.findViewById(R.id.save_popup);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String countryStr = countryEdit.getText().toString();
                String population = populationEdit.getText().toString();

                Country country = (Country) countries.get(Integer.parseInt(population));
                country.setCountryName(countryStr);
                country.setPopulation(Long.parseLong(population));
                db.updateCountry(country);
                if(customCountryList==null)
                {
                    customCountryList = new mYAdapter(activity, countries, db);
                    listView.setAdapter(customCountryList);
                }
                customCountryList.countries = (ArrayList) db.getAllCountry();
                ((BaseAdapter)listView.getAdapter()).notifyDataSetChanged();
                for (Country country1 : countries) {
                    String log = "Id: " + country1.getId() + " ,Name: " + country1.getCountryName() + " ,Population: " + country1.getPopulation();
                    // Writing Countries to log
                    Log.d("Name: ", log);
                }
                pwindo.dismiss();
            }
        });
    }
    }
