package com.example.bloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Starting_Activity extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    public static FragmentManager fragmentManager;

    String user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_);


        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawer);


        final Intent camp_id_intent =getIntent();
        user_id=camp_id_intent.getStringExtra("user_key");


        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Online Blood Bank ");

        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        fragmentManager=getSupportFragmentManager();

        if (findViewById(R.id.frame)!=null);
        {


            if (savedInstanceState!=null){

                return;
            }
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            Search_blood_camp_fragments dataFregments=new Search_blood_camp_fragments();
            fragmentTransaction.add(R.id.frame,dataFregments,null);
            fragmentTransaction.commit();
        }
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawer(GravityCompat.START);
                switch (item.getItemId()){



                    case R.id.home:
                        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                        Search_blood_camp_fragments dataFregments=new Search_blood_camp_fragments();
                        Toast.makeText(Starting_Activity.this, user_id, Toast.LENGTH_SHORT).show();
                        fragmentTransaction.add(R.id.frame,dataFregments,null);
                        fragmentTransaction.commit();
                        break;




                    case R.id.user_profile:

                        Intent userProfile=new Intent(Starting_Activity.this,User_profile.class);
                        userProfile.putExtra("user_key",user_id);
//                        Toast.makeText(Starting_Activity.this, user_id, Toast.LENGTH_SHORT).show();

                        startActivity(userProfile);

                        break;
                    case R.id.log_out:
                        Intent logOutIntent=new Intent(Starting_Activity.this,Sign_in.class);
                        startActivity(logOutIntent);

                        break;

//
                    case R.id.exit:

                        AlertDialog.Builder builder=new AlertDialog.Builder(Starting_Activity.this);
                        View view= LayoutInflater.from(Starting_Activity.this).inflate(R.layout.dialog_custom_exit,null);

//                        txt1.setText("Are Your Sure To Exit");

//                        btn1.setImageResource(R.drawable.bank);

                        builder.setPositiveButton(
                                "Yes",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Intent a = new Intent(Intent.ACTION_MAIN);
                                        a.addCategory(Intent.CATEGORY_HOME);
                                        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(a);

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



                        break;
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });

        View hView =  navigationView.getHeaderView(0);

    }


    @Override
    public void onBackPressed() {
        this.finish();
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}