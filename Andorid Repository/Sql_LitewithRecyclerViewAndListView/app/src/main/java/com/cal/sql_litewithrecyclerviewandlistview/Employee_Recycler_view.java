package com.cal.sql_litewithrecyclerviewandlistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Employee_Recycler_view extends AppCompatActivity {

    //a list to store all the products
    List<Model_Class> productList;

    RecyclerView recyclerView;
    SQLiteDatabase mDatabase;
    Adapter_Employee_RecyclerView adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee__recycler_view);


        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mDatabase = openOrCreateDatabase(MainActivity.DATABASE_NAME, MODE_PRIVATE, null);

        showEmployeesFromDatabase();
    }

    private void showEmployeesFromDatabase() {
        //we used rawQuery(sql, selectionargs) for fetching all the employees
        Cursor cursorproduct = mDatabase.rawQuery("SELECT * FROM Student", null);
        List<Model_Class> productList = new ArrayList<>();

        //if the cursor has some data
        if (cursorproduct.moveToFirst()) {
            //looping through all the records
            do {
                //pushing each record in the employee list
                productList.add(new Model_Class(
                        cursorproduct.getInt(0),
                        cursorproduct.getString(1),
                        cursorproduct.getString(2),
                        cursorproduct.getString(3),
                        cursorproduct.getString(4)
                ));
            } while (cursorproduct.moveToNext());
        }
        if (productList.isEmpty()) {
            Toast.makeText(this, "No items Found in database", Toast.LENGTH_SHORT).show();
        }
        //closing the cursor
        cursorproduct.close();

        //creating the adapter object
        adapter = new Adapter_Employee_RecyclerView(this,  productList,R.layout.custom_list_item, mDatabase);

        //adding the adapter to listview
        recyclerView.setAdapter(adapter);

        adapter.reloadEmployeesFromDatabase();  //this method is in prdouctadapter
    }

}