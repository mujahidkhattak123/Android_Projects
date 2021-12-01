package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
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

import java.util.HashMap;
import java.util.Map;

public class User_profile extends AppCompatActivity {

    private static final String  URL_User_profile = "http://cvp.crazybillys.net/MobileUser/getUserProfile";
    private String userid,user_detail,fistname,lastname,bloodtype,contactum,user_email,password,adress,provice,district
            ,status,donated, donation_date;

    ProgressBar progress_circular;
    int progress = 0;

    EditText edituserid;
    TextView  txt_user_detail,txt_first_name,txt_last_name,txt_blood_type,txt_contactum,txt_user_email,txt_password
            ,txt_address,txt_province,txt_district,txt_status,txt_donated,txt_donation_date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        progress_circular = findViewById(R.id.progress_circular);

        edituserid = findViewById(R.id.id_user_profile);
        txt_first_name = findViewById(R.id.txt_first_name);
        txt_last_name = findViewById(R.id.txt_last_name);
        txt_blood_type = findViewById(R.id.txt_blood_type);
        txt_contactum = findViewById(R.id.txt_contactum);
        txt_user_email = findViewById(R.id.txt_user_email);
        txt_password = findViewById(R.id.txt_password);
        txt_address = findViewById(R.id.txt_address);
        txt_province = findViewById(R.id.txt_province);
        txt_district = findViewById(R.id.txt_district);
        txt_status = findViewById(R.id.txt_status);
        txt_donated = findViewById(R.id.txt_donated);
        txt_donation_date = findViewById(R.id.txt_donation_date);









    }


    private void  post_for_Get_user_profile(){


        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait..");

        progressDialog.show();
        StringRequest stringRequest_Get_district=new StringRequest(Request.Method.POST, URL_User_profile, new Response.Listener<String>() {
            @Override
            public void onResponse(String response2) {





//
//                user_detail=txt_user_detail.getText().toString();
//                Toast.makeText(User_profile.this, "Success"+response2, Toast.LENGTH_SHORT).show();
//
//                txt_user_detail.setText(response2);

                progressDialog.dismiss();


                try {
                    // get JSONObject from JSON file
                    JSONObject obj = new JSONObject(response2);
                    // fetch JSONObject named employee
                    JSONObject employee = obj.getJSONObject("data");
                    // get employee name and salary
                    fistname = employee.getString("FIRSTNAME");
                    lastname = employee.getString("LASTNAME");
                    bloodtype = employee.getString("BLOODTYPE");
                    contactum = employee.getString("CONTACTNUM");
                    user_email = employee.getString("USEREMAIL");
                    password = employee.getString("PASSWORD");
                    adress = employee.getString("ADDRESS");
                    provice = employee.getString("PROVINCE");
                    district = employee.getString("DISTRICT");
                    status = employee.getString("STATUS");
                    donated = employee.getString("DONATED");
                    donation_date = employee.getString("DONATION_DATE");


                    // set employee name and salary in TextView's
                    txt_first_name.setText("First Name: "+fistname);
                    txt_last_name.setText("Last Name: "+lastname);

                    txt_blood_type.setText("Blood Type: "+bloodtype);
                    txt_contactum.setText("Contactum: "+contactum);
                    txt_user_email.setText("User_Email: "+user_email);
                    txt_password.setText("Password: "+password);
                    txt_address.setText("Address: "+adress);
                    txt_province.setText("Povince_ID: "+provice);
                    txt_district.setText("District_ID: "+district);
                    txt_status.setText("Status: "+status);
                    txt_donated.setText("Donated: "+donated);
                    txt_donation_date.setText("Donation_Date: "+donation_date);



                } catch (JSONException e) {
                    e.printStackTrace();
                }





            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                progressDialog.dismiss();

                Toast.makeText(User_profile.this,error.toString(), Toast.LENGTH_LONG).show();




            }
        }){
            @Override
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String> map=new HashMap<>();
                userid=edituserid.getText().toString();
                map.put("USER_ID",userid);

                return map;
            }
        };
        RequestQueue requestQueue_post_Get_district= Volley.newRequestQueue(this);
        requestQueue_post_Get_district.add(stringRequest_Get_district);
    }

    public void search_user_proflie(View view) {

        post_for_Get_user_profile();


    }
}