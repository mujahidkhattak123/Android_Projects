package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    private EditText user_email,user_password,fisrt_name,last_name,contact_no,province_ed_txt,district,blood_type,address;
    private Button sign_up_button;
    TextView alreadyaccount;

    Spinner spinner_Blood_Type;
    String str_blood_type;

    //for Blood Type
    ArrayList<String> BloodType_list;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_act);

        //Spinner Stating From Here
        spinner_Blood_Type = findViewById(R.id.spinner_Blood_Type);

        ArrayAdapter<CharSequence> adapter_blood_Tyye = ArrayAdapter.createFromResource(Sign_Up_Act.this, R.array.bood_Type_arrays,
                android.R.layout.simple_spinner_item);

        spinner_Blood_Type.setAdapter(adapter_blood_Tyye);

        spinner_Blood_Type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str_blood_type  = adapterView.getItemAtPosition(i).toString();

                Toast.makeText(Sign_Up_Act.this,str_blood_type , Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        user_email = findViewById(R.id.id_user_email);
        user_password = findViewById(R.id.id_user_password);
        fisrt_name = findViewById(R.id.id_first_name);
        last_name = findViewById(R.id.id_last_name);
        contact_no = findViewById(R.id.id_contact_no);
        province_ed_txt = findViewById(R.id.id_province);
        district = findViewById(R.id.id_district);
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

        fisrt_name.setFilters(new InputFilter[] {
                new InputFilter() {
                    @Override
                    public CharSequence filter(CharSequence cs, int start,
                                               int end, Spanned spanned, int dStart, int dEnd) {
                        // TODO Auto-generated method stub
                        if(cs.equals("")){ // for backspace
                            return cs;
                        }
                        if(cs.toString().matches("[a-zA-Z ]+")){
                            return cs;
                        }
                        else fisrt_name.setError("Numeric Not Allowed");
                        return "";
                    }
                }
        });

        last_name.setFilters(new InputFilter[] {
                new InputFilter() {
                    @Override
                    public CharSequence filter(CharSequence cs, int start,
                                               int end, Spanned spanned, int dStart, int dEnd) {
                        // TODO Auto-generated method stub
                        if(cs.equals("")){ // for backspace
                            return cs;
                        }
                        if(cs.toString().matches("[a-zA-Z ]+")){
                            return cs;
                        }
                        else fisrt_name.setError("Numeric Not Allowed");
                        return "";
                    }
                }
        });


    }
    private void registeruser(){
        final String useremail=user_email.getText().toString().trim();
        final String userpaswword=user_password.getText().toString().trim();
        final String firstname=fisrt_name.getText().toString().trim();
        final String lastname=last_name.getText().toString().trim();
        final String contactnumber=contact_no.getText().toString().trim();
        final String province=province_ed_txt.getText().toString().trim();
        final String userdistrict=district.getText().toString().trim();
        final String useraddress=address.getText().toString().trim();







        if (TextUtils.isEmpty(useremail)){
            user_email.setError("Email is required.");
            return;
        }
        if (TextUtils.isEmpty(userpaswword)){
            user_password.setError("password is required.");
            return;
        }
        if (TextUtils.isEmpty(contactnumber)){
            contact_no.setError("Contact is required.");
            return;
        }

        if (TextUtils.isEmpty(str_blood_type)){
            blood_type.setError("Blood is required.");
            return;
        }
        if (TextUtils.isEmpty(firstname)){
            fisrt_name.setError("First is required.");
            return;
        }
        if (TextUtils.isEmpty(lastname)){
            last_name.setError("Last is required.");
            return;
        }

        if (TextUtils.isEmpty(province)){
            province_ed_txt.setError("Province is required.");
            return;
        }

        if (TextUtils.isEmpty(userdistrict)){
            district.setError("District is required.");
            return;
        }


        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait..");

        progressDialog.show();

        StringRequest stringRequest=new StringRequest(Request.Method.POST, rigister_Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(Sign_Up_Act.this, "You Have Successfully Created Your Account ", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Sign_Up_Act.this,Sign_in.class));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
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
                params.put(KEY_USER_PROVINCE,province);
                params.put(KEY_USER_DISTRICT,userdistrict);
                params.put(KEY_USER_ADDRESS,useraddress);
                params.put("BLOODTYPE",str_blood_type);
                return params;
            }

        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    @Override
    public void onClick(View view) {
        if (view==sign_up_button){
            if(user_email.getText().toString().isEmpty()) {
                user_email.setError("Invalid Email Address.");
            }else {
                if (user_email.getText().toString().trim().matches(emailPattern)) {
                    registeruser();
                } else {
                    user_email.setError("Email is InValid.");
                }
            }

        }

    }


}