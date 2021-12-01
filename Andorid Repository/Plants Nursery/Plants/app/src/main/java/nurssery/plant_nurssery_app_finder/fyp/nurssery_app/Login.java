package nurssery.plant_nurssery_app_finder.fyp.nurssery_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import nurssery.plant_nurssery_app_finder.fyp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private EditText email, password;
    private Button login;
    private android.widget.TextView signup;
    private ProgressBar progressBar;

    private FirebaseAuth firebaseAuth;
    private final String KEY = "edittextValue";


    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.txt_email);
        password = findViewById(R.id.txt_password);
        login = findViewById(R.id.btn_login);
        signup = findViewById(R.id.txt_signup);
        progressBar= findViewById(R.id.Bar);
        email.setText(getValue());


        firebaseAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {

                saveFromEditText(email.getText().toString());

                String txt_email = email.getText().toString().trim();
                String txt_password = password.getText().toString().trim();

                if (TextUtils.isEmpty(txt_email)) {
                    Toast.makeText(Login.this, "Please enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(txt_password)) {
                    Toast.makeText(Login.this, "Please enter password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(Login.this, "Password is too short", Toast.LENGTH_SHORT).show();
                }

                progressBar.setVisibility(android.view.View.VISIBLE);

                firebaseAuth.signInWithEmailAndPassword(txt_email, txt_password)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@androidx.annotation.NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {

                                    Intent intent= new Intent(Login.this,Admin_Dashboard.class);
                                    startActivity(intent);

                                } else {

                                    Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();

                                }

                            }
                        });


            }
        });


        signup.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Intent intent = new Intent(Login.this,Signup.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private String getValue() {
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        String savedValue = sharedPref.getString(KEY, ""); //the 2 argument return default value

        return savedValue;
    }

    private void saveFromEditText(String text) {
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(KEY, text);
        editor.apply();
    }


}