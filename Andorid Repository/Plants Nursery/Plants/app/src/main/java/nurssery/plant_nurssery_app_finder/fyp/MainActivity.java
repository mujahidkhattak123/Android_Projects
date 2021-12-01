package nurssery.plant_nurssery_app_finder.fyp;

import android.content.Intent;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import nurssery.plant_nurssery_app_finder.fyp.nurssery_app.Login;
import nurssery.plant_nurssery_app_finder.fyp.nurssery_app.MapsActivity2;


public class MainActivity extends AppCompatActivity {
          Button mlogin;
    Button user;

    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mlogin=(Button) findViewById(R.id.btn_mlogin);
        user=(Button) findViewById(R.id.btn_user);

        mlogin.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                startActivity(new Intent(MainActivity.this, Login.class));
//                Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_SHORT).show();
            }
        });

        user.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                startActivity(new Intent(MainActivity.this, MapsActivity2.class));
//                Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_SHORT).show();
            }
        });


    }



}
