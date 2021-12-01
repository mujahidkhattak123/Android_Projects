package mechanic.mechanic_app_finder.fyp;

import android.content.Intent;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import mechanic.mechanic_app_finder.fyp.mechanic_app.Login;
import mechanic.mechanic_app_finder.fyp.mechanic_app.Map_Data_Selection;


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
                startActivity(new Intent(MainActivity.this, Map_Data_Selection.class));
//                Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_SHORT).show();
            }
        });


    }



}
