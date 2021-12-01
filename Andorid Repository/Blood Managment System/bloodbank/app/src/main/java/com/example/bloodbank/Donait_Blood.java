package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Donait_Blood extends AppCompatActivity {

    private static final String URL_province = "http://cvp.crazybillys.net/MobileUser/bloodDonationRequest";

  //  http://cvp.crazybillys.net/MobileUser/blood_camp_donor

    public static final String  USER_ID ="USER_ID";
    public static final String  CAMP_ID ="CAMP_ID";
    private RadioGroup radio_campGroup;
    private RadioButton radio_camp_button;

   //String For Camp
    String camp_name,camp_address,camp_id,camp_details,donation;

    private TextView txt_camp_name,txt_address,txt_detail;

    CardView id_card_search_donor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donait__blood);


        radio_campGroup=(RadioGroup)findViewById(R.id.radioGroup);
        id_card_search_donor=findViewById(R.id.id_card_search_donor);


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

        txt_address.setText("Address: \n"+camp_address);

        txt_detail.setText("Details: \n"+camp_details);



        id_card_search_donor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_search_donor = new Intent(Donait_Blood.this, Search_Donor.class);



                intent_search_donor.putExtra("camp_id",camp_id);
                intent_search_donor.putExtra("camp_name",camp_name);
                intent_search_donor.putExtra("camp_address",camp_address);
                intent_search_donor.putExtra("camp_details",camp_details);



                startActivity(intent_search_donor);

            }
        });


        radio_campGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

                if(checkedId == R.id.radioButton_yes) {
                    donation="1";


                }
                else if(checkedId == R.id.radioButton_no) {
                    donation = "0";

                }
            }
        });



    }

    private void post_for_Get_Blood_Camp_detail(){

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait..");
        progressDialog.show();


        StringRequest stringRequest_Blood_Camp_detail=new StringRequest(Request.Method.POST, URL_province, new Response.Listener<String>() {
            @Override
            public void onResponse(String response2_blood_camp_detail) {

                Toast.makeText(Donait_Blood.this, "Success"+response2_blood_camp_detail, Toast.LENGTH_SHORT).show();


                progressDialog.dismiss();


                try {

                    JSONObject object_Blood_Camp_detail=new JSONObject(response2_blood_camp_detail);
                    JSONArray jsonArray1=object_Blood_Camp_detail.getJSONArray("data");
                    for (int i = 0; i < jsonArray1.length(); i++) {
                        JSONObject distrt = jsonArray1.getJSONObject(i);


                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Donait_Blood.this,error.toString(), Toast.LENGTH_LONG).show();




            }
        }){
            @Override
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String> map_get_blood_camp_detail=new HashMap<>();



                map_get_blood_camp_detail.put(USER_ID,"184");
                map_get_blood_camp_detail.put(CAMP_ID,camp_id);
                map_get_blood_camp_detail.put("DONATION",donation);



                return map_get_blood_camp_detail;
            }
        };
        RequestQueue requestQueue_post_Blood_Camp_detail= Volley.newRequestQueue(this);
        requestQueue_post_Blood_Camp_detail.add(stringRequest_Blood_Camp_detail);

    }

    public void request_blood_donation(View view) {




        if (radio_campGroup.getCheckedRadioButtonId() == -1)
        {
            Toast.makeText(getApplicationContext(), "Please select Yes/No", Toast.LENGTH_SHORT).show();

        }
        else
        {
            int selectedId=radio_campGroup.getCheckedRadioButtonId();
            radio_camp_button=(RadioButton)findViewById(selectedId);
            post_for_Get_Blood_Camp_detail();



        }


    }
}