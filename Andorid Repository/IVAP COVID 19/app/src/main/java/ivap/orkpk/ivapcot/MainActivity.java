package ivap.orkpk.ivapcot;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;
    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager=getSupportFragmentManager();
        if (findViewById(R.id.datacontainer)!=null);
        {
            if (savedInstanceState!=null){

                return;
            }
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            DataFregments dataFregments=new DataFregments();
            fragmentTransaction.add(R.id.datacontainer,dataFregments,null);
            fragmentTransaction.commit();
        }
    }
}