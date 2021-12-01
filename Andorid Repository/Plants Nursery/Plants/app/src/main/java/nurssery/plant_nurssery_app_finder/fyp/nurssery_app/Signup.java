package nurssery.plant_nurssery_app_finder.fyp.nurssery_app;

import android.content.Intent;
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

public class Signup extends AppCompatActivity {

    private EditText txtEmail, txtPassword, txtConfirmPassword;
    private Button btn_register;
    private ProgressBar txtProgressBar;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);

        txtEmail= findViewById(R.id.email);
        txtPassword= findViewById(R.id.password);
        txtConfirmPassword= findViewById(R.id.confirmPassword);
        txtProgressBar= findViewById(R.id.progressBar);
        btn_register= findViewById(R.id.register);

        firebaseAuth= FirebaseAuth.getInstance();





        btn_register.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {

                String email= txtEmail.getText().toString().trim();
                String password= txtPassword.getText().toString().trim();
                String confirmPassword= txtConfirmPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Signup.this, "Please enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Signup.this, "Please enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(confirmPassword)) {
                    Toast.makeText(Signup.this, "Please enter confirmPassword", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (password.length()<6){
                    Toast.makeText(Signup.this, "Password is too short", Toast.LENGTH_SHORT).show();
                }

                txtProgressBar.setVisibility(android.view.View.VISIBLE);


                if (password.equals(confirmPassword)) {

                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@androidx.annotation.NonNull Task<AuthResult> task) {
                                    txtProgressBar.setVisibility(android.view.View.GONE);
                                    if (task.isSuccessful()) {

                                        Intent intent= new Intent(Signup.this, Login.class);
                                        startActivity(intent);

                                        Toast.makeText(Signup.this, "Registration completed", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(Signup.this, "Authentication failed" , Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });
                }
            }
        });

    }

}