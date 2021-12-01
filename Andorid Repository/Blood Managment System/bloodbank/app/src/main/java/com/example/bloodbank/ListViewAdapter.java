package com.example.bloodbank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Belal on 9/5/2017.
 */

public class ListViewAdapter extends ArrayAdapter<model_class_blood> {

    //the hero list that will be displayed
    private List<model_class_blood> model_class_bloods;

    //the context object
    private Context mCtx;

    //here we are getting the herolist and context
    //so while creating the object of this adapter class we need to give herolist and context
    public ListViewAdapter(List<model_class_blood> model_class_bloods, Context mCtx) {
        super(mCtx, R.layout.list_items, model_class_bloods);
        this.model_class_bloods = model_class_bloods;
        this.mCtx = mCtx;
    }

    //this method will return the list item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //getting the layoutinflater
        LayoutInflater inflater = LayoutInflater.from(mCtx);

        //creating a view with our xml layout
        View listViewItem = inflater.inflate(R.layout.list_items, null, true);

        //getting text views
        TextView textViewName = listViewItem.findViewById(R.id.textViewName);
        TextView textViewImageUrl = listViewItem.findViewById(R.id.textViewImageUrl);

        //Getting the hero for the specified position
        model_class_blood model_class_blood = model_class_bloods.get(position);

        //setting hero values to textviews
        textViewName.setText(model_class_blood.Camp_Name);
        textViewImageUrl.setText(model_class_blood.Camp_Adress_);

        //returning the listitem
        return listViewItem;
    }
}
