package com.cal.listview_practice;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView simpleList;
    String countryList[] = {"Mujahid", "Aqaib", "Atif", "Rahim", "Nadir", "Hasan","Faiza", "Ramzam", "zulfiqar", "Ahmad", "Harron", "Iqbal"};
    int flags[] = {R.drawable.as1, R.drawable.as2,
            R.drawable.as3, R.drawable.as4,
            R.drawable.as5, R.drawable.as6
            , R.drawable.as7, R.drawable.as2
            , R.drawable.as8, R.drawable.as9
            , R.drawable.as3, R.drawable.as4
            , R.drawable.as5, R.drawable.as6};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleList = (ListView) findViewById(R.id.simpleListView);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), countryList, flags);
        simpleList.setAdapter(customAdapter);
    }
}