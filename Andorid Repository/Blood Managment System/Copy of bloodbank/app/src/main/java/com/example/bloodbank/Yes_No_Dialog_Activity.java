package com.example.bloodbank;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
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

public class Yes_No_Dialog_Activity extends AppCompatActivity {
    private static final String status_Url="http://cvp.crazybillys.net/MobileUser/bloodDonationRequest";

    public static final String  KEY_USER_ID ="USER_ID";
    public static final String  KEY_DONATION ="DONATION";

    EditText txtuser_id;

    String status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yes__no__dialog_);

        txtuser_id=findViewById(R.id.txt_user_id);



    }

    public void post(View view2) {


        final String txtuserid=txtuser_id.getText().toString().trim();



        AlertDialog.Builder builder=new AlertDialog.Builder(Yes_No_Dialog_Activity.this);
        View view= LayoutInflater.from(Yes_No_Dialog_Activity.this).inflate(R.layout.dialog_custom,null);

//                        txt1.setText("Are Your Sure To Exit");

//                        btn1.setImageResource(R.drawable.bank);

        builder.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {


                    }
                });

        builder.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                });

        builder.setView(view);
        builder.show();


        StringRequest stringRequest=new StringRequest(Request.Method.POST, status_Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(Yes_No_Dialog_Activity.this, response, Toast.LENGTH_LONG).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Yes_No_Dialog_Activity.this,error.toString(), Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String,String> getParams(){
                Map<String ,String> params=new HashMap<String,String>();
                params.put(KEY_USER_ID,txtuserid);
//                params.put(KEY_DONATION,status);

                return params;
            }

        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);




    }


    }
