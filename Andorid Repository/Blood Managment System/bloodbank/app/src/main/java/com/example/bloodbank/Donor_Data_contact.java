package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Donor_Data_contact extends AppCompatActivity {


    //String For Donor Detail
    String FIRSTNAME,LASTNAME,BLOODTYPE,CONTACTNUM;

    private TextView txt_camp_name,txt_address,txt_detail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor__data_contact);


        //Casting For TextView
        txt_camp_name=findViewById(R.id.txt_camp_name);
        txt_address=findViewById(R.id.txt_address);
        txt_detail=findViewById(R.id.txt_detail);


        final Intent camp_id_intent =getIntent();
        FIRSTNAME=camp_id_intent.getStringExtra("FIRSTNAME");

        final Intent camp_name_intent =getIntent();
        LASTNAME=camp_name_intent.getStringExtra("LASTNAME");


        final Intent camp_address_intent =getIntent();
        BLOODTYPE=camp_address_intent.getStringExtra("BLOODTYPE");


        final Intent camp_details_intent =getIntent();
        CONTACTNUM=camp_details_intent.getStringExtra("CONTACTNUM");

        txt_camp_name.setText(FIRSTNAME );

        txt_address.setText(BLOODTYPE);

        txt_detail.setText(CONTACTNUM);


    }

    public void btn_call_now(View view) {

        String num=txt_detail.getText().toString();

        ClipboardManager clipboard= (ClipboardManager) view.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData= ClipData.newPlainText("Copied ",num);

        clipboard.setPrimaryClip(clipData);



        Intent i=new Intent( (Intent.ACTION_DIAL) );
        i.setData( Uri.parse( "tel:" +num) );

        view.getContext().startActivity(i);
    }
}