package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
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

import java.util.HashMap;
import java.util.Map;

public class Sign_in extends AppCompatActivity implements View.OnClickListener {
    private static final String login_Url = "https://cvp.crazybillys.net/MobileUser/login";
    public static final String KEY_USER_EMAIL = "USEREMAIL";
    public static final String KEY_USER_PASSWORD = "PASSWORD";

    private EditText editText_user_email, editText_user_password;
    private Button login_button;
    private TextView create_account;

    private final String KEY = "edittextValue";

    private String useremial;
    private String password;

    ProgressBar progress_circular;
    int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        editText_user_email = findViewById(R.id.id_login_user_email);
        editText_user_password = findViewById(R.id.id_user_login_password);

        progress_circular = findViewById(R.id.progress_circular);


        editText_user_email.setText(getValue());
        login_button = findViewById(R.id.id_log_in_btn);
        create_account = findViewById(R.id.id_create_account);
        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Sign_in.this, Sign_Up_Act.class));
            }
        });

        login_button.setOnClickListener(this);

    }

//    private void userlogin() {
//        useremial = editText_user_email.getText().toString().trim();
//        password = editText_user_password.getText().toString().trim();
//        if (TextUtils.isEmpty(useremial)) {
//            editText_user_email.setError("Email is required.");
//            return;
//        }
//        if (TextUtils.isEmpty(password)) {
//            editText_user_password.setError("Email is required.");
//            return;
//        }
//
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, login_Url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                Toast.makeText(Sign_in.this, response.toString(), Toast.LENGTH_SHORT).show();
//
//                openprofile();
//                progress_circular.setVisibility(View.GONE);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(Sign_in.this, error.toString(), Toast.LENGTH_LONG).show();
//
//            }
//        }) {
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> map = new HashMap<>();
//                map.put(KEY_USER_EMAIL, useremial);
//                map.put(KEY_USER_PASSWORD, password);
//                return map;
//
//            }
//        };
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        requestQueue.add(stringRequest);
//    }

    private void openprofile() {
        Intent intent = new Intent(this, Starting_Activity.class);
//        progress_circular.setVisibility(View.VISIBLE);

        startActivity(intent);

    }

    @Override
    public void onClick(View view) {

        saveFromEditText(editText_user_email.getText().toString());


//        progress_circular.setVisibility(View.VISIBLE);
        Login();
        //        userlogin();


    }


    private String getValue() {
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        String savedValue = sharedPref.getString(KEY, ""); //the 2 argument return default value

        return savedValue;
    }

    private void saveFromEditText(String text) {
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(KEY, text);
        editor.apply();
    }


    public void Login() {

        if (editText_user_email.getText().toString().equals("")) {
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
        } else if (editText_user_password.getText().toString().equals("")) {
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
        } else {


            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Please Wait..");

            progressDialog.show();

            useremial = editText_user_email.getText().toString().trim();
            password = editText_user_password.getText().toString().trim();


            StringRequest request = new StringRequest(Request.Method.POST, login_Url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    progressDialog.dismiss();
                    startActivity(new Intent(getApplicationContext(), Starting_Activity.class));

                    Toast.makeText(Sign_in.this, response, Toast.LENGTH_SHORT).show();


//
//                    if (response.equalsIgnoreCase("logged in successfully")) {
//
//                        editText_user_email.setText("");
//                        editText_user_password.setText("");
//                        startActivity(new Intent(getApplicationContext(), Main_Data_Fragments.class));
//                        Toast.makeText(Sign_in.this, response, Toast.LENGTH_SHORT).show();
//                    } else {
//                        Toast.makeText(Sign_in.this, response, Toast.LENGTH_SHORT).show();
//                    }




                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.dismiss();
                    Toast.makeText(Sign_in.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            ) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put(KEY_USER_EMAIL, useremial);
                    params.put(KEY_USER_PASSWORD, password);
                    return params;

                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(Sign_in.this);
            requestQueue.add(request);


        }
    }

    public void moveToRegistration(View view) {
    }
}

