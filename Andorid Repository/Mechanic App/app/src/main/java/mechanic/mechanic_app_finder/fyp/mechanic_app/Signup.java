package mechanic.mechanic_app_finder.fyp.mechanic_app;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import mechanic.mechanic_app_finder.fyp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {

    private EditText txtEmail, txtPassword, txtConfirmPassword;
    private Button btn_register;
    private ProgressBar txtProgressBar;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


    String email,pass;
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

                email= txtEmail.getText().toString().trim();
                pass= txtPassword.getText().toString().trim();
                String confirmPassword= txtConfirmPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    txtEmail.setError("Email is Required");
                    return;
                }
                if (TextUtils.isEmpty(pass)) {
                    txtPassword.setError("Password is Required");
                    return;
                }
                if (TextUtils.isEmpty(confirmPassword)) {
                    txtConfirmPassword.setError("Confirm Password is Required");
                    return;
                }


                if (pass.length()<6){
                    txtPassword.setError("Password is too short");

                }



                if (pass.equals(confirmPassword)) {


                    if(txtEmail.getText().toString().isEmpty()) {
                        txtEmail.setError("Invalid Email Address.");
                    }else {
                        if (txtEmail.getText().toString().trim().matches(emailPattern)) {
                            registeruser();
                        } else {
                            txtEmail.setError("Email is InValid.");
                        }
                    }

                }
            }
        });



    }

    private void  registeruser(){
        firebaseAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@androidx.annotation.NonNull Task<AuthResult> task) {
                        txtProgressBar.setVisibility(android.view.View.VISIBLE);
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