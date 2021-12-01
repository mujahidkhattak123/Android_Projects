package nurssery.plant_nurssery_app_finder.fyp.nurssery_app;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import nurssery.plant_nurssery_app_finder.fyp.R;

public class Dashboard extends AppCompatActivity {
   private DatabaseReference databaseReference;
    private android.widget.TextView mRetrieve,mAdmin;

    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        mRetrieve = findViewById(R.id.Retrieve);
        mAdmin = findViewById(R.id.txt_Admin);


        databaseReference= FirebaseDatabase.getInstance().getReference().child("Hostel Location");


      mRetrieve.setOnClickListener(new android.view.View.OnClickListener() {
          @Override
          public void onClick(android.view.View view) {

              Intent intent= new Intent(Dashboard.this, MapsActivity2.class);
              startActivity(intent);
          }
      });

      mAdmin.setOnClickListener(new android.view.View.OnClickListener() {
          @Override
          public void onClick(android.view.View view) {
              Intent intent= new Intent(Dashboard.this, Admin_Dashboard.class);
              startActivity(intent);
          }
      });



    }
}