package mechanic.mechanic_app_finder.fyp.mechanic_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import mechanic.mechanic_app_finder.fyp.R;

public class Map_Data_Selection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map__data__selection);
    }

    public void Engine_Mechanic(View view) {

        startActivity(new Intent(Map_Data_Selection.this, Mechanic_Map.class));


    }

    public void Electrician(View view) {

        startActivity(new Intent(Map_Data_Selection.this, Electrcian_Map.class));

    }

    public void Wheel_Alignment(View view) {

        startActivity(new Intent(Map_Data_Selection.this, Wheel_Alignment_Map.class));

    }

    public void Hospital_Map(View view) {
        startActivity(new Intent(Map_Data_Selection.this, Hospital_map_Acvt.class));

    }
}