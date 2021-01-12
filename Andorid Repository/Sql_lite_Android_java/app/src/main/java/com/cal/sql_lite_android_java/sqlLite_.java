package com.cal.sql_lite_android_java;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class sqlLite_ extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "countryData";

    // Country table name
    private static final String TABLE_COUNTRY= "Country";

    // Country Table Columns names
    private static final String KEY_ID = "id";
    private static final String COUNTRY_NAME = "CountryName";
    private static final String POPULATION = "Population";


    public sqlLite_(Context context){

        super(context,DATABASE_NAME,DATABASE_VERSION,null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_COUNTRY_TABLE = "CREATE TABLE " + TABLE_COUNTRY + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + COUNTRY_NAME + " TEXT,"
                + COUNTRY_NAME + " LONG" + ")";
        sqLiteDatabase.execSQL(CREATE_COUNTRY_TABLE);

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COUNTRY);
        // Create tables again
        onCreate(db);
    }

    // Adding new country
    public void addCountry(Country country){

        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(COUNTRY_NAME,country.getCountryName());
        contentValues.put(POPULATION,country.getPopulation());

        //Inerting Rows
        database.insert(TABLE_COUNTRY,null,contentValues);
        database.close();
    }

    // Getting single country
    Country getCountry(int id) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query(TABLE_COUNTRY, new String[] { KEY_ID,
                        COUNTRY_NAME, POPULATION }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

            Country country=new Country(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),cursor.getLong(2));
            // return country

        return country;
    }

    // Getting All Countries
    public List getAllCountry(){

        List country_List=new ArrayList();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_COUNTRY;

        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery(selectQuery,null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()){

            do {
                Country country = new Country();
                country.setId(Integer.parseInt(cursor.getString(0)));
                country.setCountryName(String.valueOf(Integer.parseInt(cursor.getString(1))));
                country.setPopulation(Integer.parseInt(cursor.getString(2)));

                // Adding country to list
                country_List.add(country);

            }
            while (cursor.moveToLast());
        }

        return country_List;
    }


    // Updating single country
    public int updateCountry(Country country) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COUNTRY_NAME, country.getCountryName());
        values.put(POPULATION, country.getPopulation());

        // updating row
        return db.update(TABLE_COUNTRY, values, KEY_ID + " = ?",
                new String[] { String.valueOf(country.getId()) });
    }

    // Deleting single country
    public void deleteCountry(Country country) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_COUNTRY, KEY_ID + " = ?",
                new String[] { String.valueOf(country.getId()) });
        db.close();
    }

    // Deleting all countries
    public void deleteAllCountries() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_COUNTRY,null,null);
        db.close();
    }

    // Getting countries Count
    public int getCountriesCount() {
        String countQuery = "SELECT  * FROM " + TABLE_COUNTRY;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

}
