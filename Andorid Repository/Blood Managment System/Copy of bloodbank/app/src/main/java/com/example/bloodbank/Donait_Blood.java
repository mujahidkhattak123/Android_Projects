package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
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

    public static final String  USER_ID ="USER_ID";
    public static final String  CAMP_ID ="CAMP_ID";

    private String user_id;
    private String camp_id;
    private EditText edit_userid, edit_camp_id;
    ProgressBar progress_circular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donait__blood);

//        edit_userid = findViewById(R.id.edit_userid);
//        edit_camp_id = findViewById(R.id.edit_camp_id);



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


                user_id = edit_userid.getText().toString();
                camp_id = edit_camp_id.getText().toString();
                map_get_blood_camp_detail.put(USER_ID,"184");
                map_get_blood_camp_detail.put(CAMP_ID,"2");
                map_get_blood_camp_detail.put("DONATION","1");



                return map_get_blood_camp_detail;
            }
        };
        RequestQueue requestQueue_post_Blood_Camp_detail= Volley.newRequestQueue(this);
        requestQueue_post_Blood_Camp_detail.add(stringRequest_Blood_Camp_detail);

    }

    public void request_blood_donation(View view) {

        post_for_Get_Blood_Camp_detail();

    }
}