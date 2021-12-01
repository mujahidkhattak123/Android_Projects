package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Sign_Up_Act extends AppCompatActivity implements View.OnClickListener {

    private static final String rigister_Url="https://cvp.crazybillys.net/MobileUser/SignUp";
    public static final String  KEY_USER_EMAIL ="USEREMAIL";
    public static final String  KEY_USER_PASSWORD ="PASSWORD";
    public static final String  KEY_USER_FIRST_NAME ="FIRSTNAME";
    public static final String  KEY_USER_LAST_NAME ="LASTNAME";
    public static final String  KEY_USER_PHONE_NUMBER ="CONTACTNUM";
    public static final String  KEY_USER_BLOOD_TYPE ="BLOODTYPE";
    public static final String  KEY_USER_DISTRICT ="DISTRICT";
    public static final String  KEY_USER_PROVINCE ="PROVINCE";
    public static final String  KEY_USER_ADDRESS ="ADDRESS";
    private EditText user_email,user_password,fisrt_name,last_name,contact_no,province,district,blood_type,address;
    private Button sign_up_button;
    TextView alreadyaccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_act);
        user_email = findViewById(R.id.id_user_email);
        user_password = findViewById(R.id.id_user_password);
        fisrt_name = findViewById(R.id.id_first_name);
        last_name = findViewById(R.id.id_last_name);
        contact_no = findViewById(R.id.id_contact_no);
        province = findViewById(R.id.id_province);
        district = findViewById(R.id.id_district);
        blood_type = findViewById(R.id.id_Blood_type);
        address = findViewById(R.id.id_address);

        alreadyaccount = findViewById(R.id.already_account);
        alreadyaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Sign_Up_Act.this,Sign_in.class));
            }
        });

        sign_up_button = findViewById(R.id.id_sign_up_btn);
        sign_up_button.setOnClickListener(this);
    }
    private void registeruser(){
        final String useremail=user_email.getText().toString().trim();
        final String userpaswword=user_password.getText().toString().trim();
        final String firstname=fisrt_name.getText().toString().trim();
        final String lastname=last_name.getText().toString().trim();
        final String contactnumber=contact_no.getText().toString().trim();
        final String userprovince=province.getText().toString().trim();
        final String userdistrict=district.getText().toString().trim();
        final String userbloodtype=blood_type.getText().toString().trim();
        final String useraddress=address.getText().toString().trim();

        if (TextUtils.isEmpty(useremail)){
            user_email.setError("Email is required.");
            return;
        }
        if (TextUtils.isEmpty(userpaswword)){
            user_password.setError("password is required.");
            return;
        }

        StringRequest stringRequest=new StringRequest(Request.Method.POST, rigister_Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(Sign_Up_Act.this, response, Toast.LENGTH_LONG).show();
                startActivity(new Intent(Sign_Up_Act.this,Sign_in.class));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Sign_Up_Act.this,error.toString(), Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String,String> getParams(){
                Map<String ,String> params=new HashMap<String,String>();
                params.put(KEY_USER_EMAIL,useremail);
                params.put(KEY_USER_PASSWORD,userpaswword);
                params.put(KEY_USER_PASSWORD,userpaswword);
                params.put(KEY_USER_FIRST_NAME,firstname);
                params.put(KEY_USER_LAST_NAME,lastname);
                params.put(KEY_USER_PHONE_NUMBER,contactnumber);
                params.put(KEY_USER_BLOOD_TYPE,userbloodtype);
                params.put(KEY_USER_PROVINCE,userprovince);
                params.put(KEY_USER_DISTRICT,userdistrict);
                params.put(KEY_USER_ADDRESS,useraddress);
                return params;
            }

        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    @Override
    public void onClick(View view) {
        if (view==sign_up_button){

            registeruser();
        }

    }


}