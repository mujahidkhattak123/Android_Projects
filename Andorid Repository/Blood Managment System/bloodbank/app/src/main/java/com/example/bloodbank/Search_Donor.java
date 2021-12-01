package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Search_Donor extends AppCompatActivity {

    //String For Camp
    String camp_name,camp_address,camp_id,camp_details,donation;

    //String To Get Data From Parameter
    String FIRSTNAME,LASTNAME,CONTACTNUM,BLOODTYPE,ADDRESS;

    String str_blood_type;

    private TextView txt_camp_name,txt_address,txt_detail;

    //All Urls
    private static final String URL_Blood_camp_donor =  "http://cvp.crazybillys.net/MobileUser/blood_camp_donor";

    //Spinner
    Spinner spinner_Blood_Type;

    //Model Class
    List<model_class_blood> Blood_Donor_List;

    //listview object
    ListView listView;


    //for Blood Type
    ArrayList<String> BloodType_list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search__donor);


        //initializing listview and hero list
        listView = (ListView) findViewById(R.id.listView);

        Blood_Donor_List = new ArrayList<>();


        //Spinner Stating From Here
        spinner_Blood_Type = findViewById(R.id.spinner_Blood_Type);

        ArrayAdapter<CharSequence> adapter_blood_Tyye = ArrayAdapter.createFromResource(Search_Donor.this, R.array.bood_Type_arrays,
                android.R.layout.simple_spinner_item);

        spinner_Blood_Type.setAdapter(adapter_blood_Tyye);



        spinner_Blood_Type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str_blood_type  = adapterView.getItemAtPosition(i).toString();

                //creating custom adapter object
                ListViewAdapter adapter = new ListViewAdapter(Blood_Donor_List, getApplicationContext());

                adapter.clear();
                listView.setAdapter(null);

                adapter.notifyDataSetChanged();


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Casting For TextView
        txt_camp_name=findViewById(R.id.txt_camp_name);
        txt_address=findViewById(R.id.txt_address);
        txt_detail=findViewById(R.id.txt_detail);



        final Intent camp_id_intent =getIntent();
        camp_id=camp_id_intent.getStringExtra("camp_id");

        final Intent camp_name_intent =getIntent();
        camp_name=camp_name_intent.getStringExtra("camp_name");


        final Intent camp_address_intent =getIntent();
        camp_address=camp_address_intent.getStringExtra("camp_address");


        final Intent camp_details_intent =getIntent();
        camp_details=camp_details_intent.getStringExtra("camp_details");



        txt_camp_name.setText(camp_name);

    }

    public void btn_search_blood_type(View view) {

//        Toast.makeText(this, camp_id+" And " +camp_name, Toast.LENGTH_SHORT).show();

        post_for_Get_Blood_Camp_detail();
    }


    private void post_for_Get_Blood_Camp_detail(){

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait..");
        progressDialog.show();

        StringRequest stringRequest_campt_detail=new StringRequest(Request.Method.POST, URL_Blood_camp_donor, new Response.Listener<String>() {
            @Override
            public void onResponse(String response2) {
                progressDialog.dismiss();


//                Toast.makeText(Search_Donor.this, response2, Toast.LENGTH_SHORT).show();

                try {
                    //getting the whole json object from the response
                    JSONObject obj = new JSONObject(response2);

                    //we have the array named hero inside the object
                    //so here we are getting that json array
                    JSONArray heroArray = obj.getJSONArray("data");


                    //now looping through all the elements of the json array
                    for (int i = 0; i < heroArray.length(); i++) {


                        //getting the json object of the particular index inside the array
                        JSONObject jsonObject = heroArray.getJSONObject(i);
                        FIRSTNAME=jsonObject.getString("FIRSTNAME");
                        BLOODTYPE=jsonObject.getString("BLOODTYPE");
                        LASTNAME=jsonObject.getString("LASTNAME");
                        CONTACTNUM=jsonObject.getString("CONTACTNUM");
                        ADDRESS=jsonObject.getString("ADDRESS");


                        // hero object and giving them the values from json object
                        model_class_blood camp_model_name = new model_class_blood("Name :"+FIRSTNAME+ " "

                                +LASTNAME,"Blood Type :"+BLOODTYPE,CONTACTNUM,CONTACTNUM);



                        //adding the hero to herolist
                        Blood_Donor_List.add(camp_model_name);
                    }

                    //creating custom adapter object
                    ListViewAdapter adapter = new ListViewAdapter(Blood_Donor_List,getApplicationContext());


                    //adding the adapter to listview
                    listView.setAdapter(adapter);

//                     ListView setOnItemClickListener function apply here.

                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
                    {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view,
                                                int position, long id) {

//                            Toast.makeText(getActivity(), camp_id, Toast.LENGTH_SHORT).show();
//                            Toast.makeText(getActivity(), camp_name, Toast.LENGTH_SHORT).show();

                            FIRSTNAME=Blood_Donor_List.get(position).getCamp_Name();
                            LASTNAME=Blood_Donor_List.get(position).getCamp_id();
                            BLOODTYPE=Blood_Donor_List.get(position).getCamp_Adress_();
                            CONTACTNUM=Blood_Donor_List.get(position).getCamp_details();

                            Intent intent = new Intent(Search_Donor.this,Donor_Data_contact.class);
//                            intent.putExtra("camp_id",camp_id);
//                            intent.putExtra("camp_name",camp_name);
//                            intent.putExtra("camp_address",camp_address);
//                            intent.putExtra("camp_details",camp_details);


                            intent.putExtra("FIRSTNAME",FIRSTNAME);
                            intent.putExtra("LASTNAME",LASTNAME);
                            intent.putExtra("BLOODTYPE",BLOODTYPE);
                            intent.putExtra("CONTACTNUM",CONTACTNUM);





                            startActivity(intent);
                            // TODO Auto-generated method stub
                        }
                    });



                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Search_Donor.this,error.toString(), Toast.LENGTH_LONG).show();


            }
        }){
            @Override
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String> map_get_blood_camp_detail=new HashMap<>();
                map_get_blood_camp_detail.put("CAMP_ID",camp_id);
                map_get_blood_camp_detail.put("BLOODTYPE",str_blood_type);



                return map_get_blood_camp_detail;
            }
        };
        RequestQueue requestQueue_post_Blood_Camp_detail= Volley.newRequestQueue(this);
        requestQueue_post_Blood_Camp_detail.add(stringRequest_campt_detail);

    }


}