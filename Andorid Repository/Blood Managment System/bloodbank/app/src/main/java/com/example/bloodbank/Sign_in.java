package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sign_in extends AppCompatActivity implements View.OnClickListener {
    private static final String login_Url = "https://cvp.crazybillys.net/MobileUser/login";
    public static final String KEY_USER_EMAIL = "USEREMAIL";
    public static final String KEY_USER_PASSWORD = "PASSWORD";

    private EditText editText_user_email, editText_user_password;
    private Button login_button;
    private TextView create_account;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


    private final String KEY = "edittextValue";

    private String useremial;
    private String password;
    String responseCode,user_id;
    ProgressBar progress_circular;

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



    @Override
    public void onClick(View view) {



        saveFromEditText(editText_user_email.getText().toString());

        if(editText_user_email.getText().toString().isEmpty()) {
            editText_user_email.setError("Invalid Email Address.");
        }else {
            if (editText_user_email.getText().toString().trim().matches(emailPattern)) {
                Login();
            } else {
                editText_user_email.setError("Email is InValid.");
                Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
            }
        }

        if (editText_user_email.getText().toString().toString().matches("[a-zA-Z ]+")){
            editText_user_email.getText().toString();
        }

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


        if(editText_user_email.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(),"enter email address",Toast.LENGTH_SHORT).show();
        }else {
            if (editText_user_email.getText().toString().trim().matches(emailPattern)) {
                Toast.makeText(getApplicationContext(),"valid email address",Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
                editText_user_email.setError("Email is required.");

            }
        }

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

                    try {
                        JSONObject obj = new JSONObject(response);
                        responseCode = obj.getString("message");
                        user_id=obj.getString("user_id");



                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    if(responseCode.equals("success")){

                        editText_user_email.setText("");
                        editText_user_email.setText("");

                        Intent newIntent=new  Intent(getApplicationContext(),Starting_Activity.class);
                        newIntent.putExtra("user_key",user_id);
                        startActivity(newIntent);


                        Toast.makeText(Sign_in.this, "Login Successfully  ", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(Sign_in.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                    }

                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.dismiss();
//                    Toast.makeText(Sign_in.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            ) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("usermail", useremial);
                    params.put("password", password);
                    return params;

                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(Sign_in.this);
            requestQueue.add(request);


        }
    }




    @Override
    public void onBackPressed() {
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }



}

