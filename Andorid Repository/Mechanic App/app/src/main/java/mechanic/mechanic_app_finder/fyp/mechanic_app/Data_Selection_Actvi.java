package mechanic.mechanic_app_finder.fyp.mechanic_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import mechanic.mechanic_app_finder.fyp.MainActivity;
import mechanic.mechanic_app_finder.fyp.R;

public class Data_Selection_Actvi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data__selection__actvi);
    }

    public void Engine_Mechanic(View view) {

        startActivity(new Intent(Data_Selection_Actvi.this, Admin_Dashboard.class));


    }

    public void Electrician(View view) {

        startActivity(new Intent(Data_Selection_Actvi.this, Electrician_Actv.class));

    }

    public void Wheel_Alignment(View view) {

        startActivity(new Intent(Data_Selection_Actvi.this, Weel_Alignment_Act.class));

    }

    public void Hospital_acti(View view) {
        startActivity(new Intent(Data_Selection_Actvi.this, Hospital_Actvity.class));

    }
}