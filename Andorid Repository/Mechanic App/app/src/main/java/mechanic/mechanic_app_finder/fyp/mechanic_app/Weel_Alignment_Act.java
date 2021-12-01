package mechanic.mechanic_app_finder.fyp.mechanic_app;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

import mechanic.mechanic_app_finder.fyp.R;


public class Weel_Alignment_Act extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private EditText txt_hostelName,txt_address,txt_phoneNumber,txt_emial,txt_latitude,txt_longitude;
    private android.widget.Spinner wifispinner, foodspinner, generatorspinner, summerroomsspinner, watercoolerspinner, watergeyserspinner;
    private RadioButton radioGenderMale, radioGenderFemale;
    private Button send,btn_choose;
    private ImageView imageView;
    private DatabaseReference databaseReference;
    String gender = "";
    StorageReference storageReference = FirebaseStorage.getInstance().getReference("Wheel_alignment Details");
    StorageTask mUploadTask;
    Uri mUri;




    String[] wifi= {"Select","Yes","No"};
    String wifiValue;

    String[] food= {"Select","Available","Not Available"};
    String foodValue;

    String[] electricfacility = {"Select","Generator","UPS","None"};
    String electricValue;

    String[] summerroomsfacility = {"Select","Air cooler","Air conditioner"};
    String summerroomValue;

    String[] electronicwatercooler = {"Select","Available","Not Available"};
    String electronicValue;

    String[] electronicwatergeyser = {"Select","Available","Not Available"};
    String eleValue;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    private static final int PICK_IMAGE_RE = 1;

    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weel__alignment_);

        txt_hostelName= findViewById(R.id.txt_hostelName);
        txt_address= findViewById(R.id.txt_address);
        txt_phoneNumber= findViewById(R.id.txt_phoneNumber);
        txt_emial= findViewById(R.id.txt_emial);
        txt_latitude= findViewById(R.id.txt_latitude);
        txt_longitude= findViewById(R.id.txt_longitude);

        radioGenderMale= findViewById(R.id.radioButtonMale);
        radioGenderFemale= findViewById(R.id.radioButtonFemale);
        send= findViewById(R.id.send);
        imageView= findViewById(R.id.imageView);
        btn_choose= findViewById(R.id.btn_choose);




        txt_hostelName.setText("");
        txt_address.setText("");
        txt_phoneNumber.setText("");
        txt_emial.setText("");
        txt_latitude.setText("");
        txt_longitude.setText("");

        android.widget.Spinner wifispinner= findViewById(R.id.wifispinner);
        android.widget.Spinner foodspinner = findViewById(R.id.foodspinner);
        android.widget.Spinner generatorspinner= findViewById(R.id.generatorspinner);
        android.widget.Spinner summerroomsspinner= findViewById(R.id.summerroomsspinner);
        android.widget.Spinner electronicwatercoolerspinner= findViewById(R.id.watercoolerspinner);
        android.widget.Spinner electronicwatergeyserspinner= findViewById(R.id.watergeyserspinner);



        wifispinner.setOnItemSelectedListener(this);
        foodspinner.setOnItemSelectedListener(this);
        generatorspinner.setOnItemSelectedListener(this);
        summerroomsspinner.setOnItemSelectedListener(this);
        electronicwatercoolerspinner.setOnItemSelectedListener(this);
        electronicwatergeyserspinner.setOnItemSelectedListener(this);





        btn_choose.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {

                openFileChoser();
            }
        });

        send.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {

                String hostel_name= txt_hostelName.getText().toString().trim();
                String address= txt_address.getText().toString().trim();
                String phoneNumber= txt_phoneNumber.getText().toString().trim();
                String email= txt_emial.getText().toString().trim();
                String latitude = txt_latitude.getText().toString().trim();
                String longitude = txt_longitude.getText().toString().trim();

                if (radioGenderMale.isChecked()){
                    gender= "Male";
                }
                if (radioGenderFemale.isChecked()){
                    gender= "Female";
                }
                if (TextUtils.isEmpty(hostel_name)){

                    txt_hostelName.setError("Name is Required");
                }
                if (TextUtils.isEmpty(address)){
                    txt_address.setError("Adress is Required");
                }
                if (TextUtils.isEmpty(email)){
                    txt_emial.setError("Email is Required");
                }

                if (TextUtils.isEmpty(latitude)){
                    txt_latitude.setError("Lat is Required");
                }
                if (TextUtils.isEmpty(longitude)){
                    txt_longitude.setError("Longitude is Required");
                }
                if (mUploadTask != null && mUploadTask.isInProgress()) {
                    Toast.makeText(Weel_Alignment_Act.this, "Upload is in Progress", Toast.LENGTH_SHORT).show();

                }

                if (!txt_latitude.getText().toString().contains(".") || !txt_longitude.getText().toString().contains(".")) {
                    txt_longitude.setError("Dot Are Missing");
                }


                else {
                    if (txt_emial.getText().toString().trim().matches(emailPattern)) {
                        uploadData();
                    } else {
                        txt_emial.setError("Email is InValid.");
                    }
                }


            }

        });





        ArrayAdapter wifiAdapter= new ArrayAdapter(this, android.R.layout.simple_spinner_item,wifi);
        wifiAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        wifispinner.setAdapter(wifiAdapter);
        wifispinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, android.view.View view, int i, long l) {
                wifiValue = wifi[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter foodAdapter= new ArrayAdapter(this, android.R.layout.simple_spinner_item,food);
        foodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        foodspinner.setAdapter(foodAdapter);
        foodspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, android.view.View view, int i, long l) {
                foodValue= food[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter generatorAdapter= new ArrayAdapter(this, android.R.layout.simple_spinner_item,electricfacility);
        generatorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        generatorspinner.setAdapter(generatorAdapter);
        generatorspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, android.view.View view, int i, long l) {
                electricValue = electricfacility[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter summerroomsAdapter= new ArrayAdapter(this, android.R.layout.simple_spinner_item,summerroomsfacility);
        summerroomsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        summerroomsspinner.setAdapter(summerroomsAdapter);
        summerroomsspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, android.view.View view, int i, long l) {
                summerroomValue = summerroomsfacility[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter watercoolerAdapter= new ArrayAdapter(this, android.R.layout.simple_spinner_item,electronicwatercooler);
        watercoolerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        electronicwatercoolerspinner.setAdapter(watercoolerAdapter);
        electronicwatercoolerspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, android.view.View view, int i, long l) {
                electronicValue = electronicwatercooler[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter watergeyserAdapter= new ArrayAdapter(this, android.R.layout.simple_spinner_item,electronicwatergeyser);
        watergeyserAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        electronicwatergeyserspinner.setAdapter(watergeyserAdapter);
        electronicwatergeyserspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, android.view.View view, int i, long l) {
                eleValue = electronicwatergeyser[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void uploadData() {

        if (mUri != null) {
            final StorageReference fileReference = storageReference.child(System.currentTimeMillis()+ "." + getFileExtension(mUri));

            fileReference.putFile(mUri).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                @Override
                public Task<Uri> then(@androidx.annotation.NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {


                    if (!task.isSuccessful()) {
                        throw task.getException();
                    }
                    return fileReference.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@androidx.annotation.NonNull Task<Uri> task) {

                    if (task.isSuccessful()) {


                        String hostel_name= txt_hostelName.getText().toString().trim();
                        String address= txt_address.getText().toString().trim();
                        String phoneNumber= txt_phoneNumber.getText().toString().trim();
                        String email= txt_emial.getText().toString().trim();
                        String latitude = txt_latitude.getText().toString().trim();
                        String longitude = txt_longitude.getText().toString().trim();
                        Uri downloadUri = task.getResult();


                        databaseReference= FirebaseDatabase.getInstance().getReference().child("Wheel_alignment Details");
                        String keyss = databaseReference.push().getKey();
                        Admin upload = new Admin(hostel_name,address,phoneNumber,email,latitude,longitude,gender,downloadUri.toString(),
                                wifiValue,foodValue,electricValue,summerroomValue,electronicValue,eleValue);


                        databaseReference.child(keyss).setValue(upload);
                        Toast.makeText(Weel_Alignment_Act.this,"Uploaded",Toast.LENGTH_SHORT).show();
                        finish();

                    } else {
                        Toast.makeText(Weel_Alignment_Act.this, "upload failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


    }

    private String getFileExtension(Uri uri) {
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }


    private void openFileChoser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,PICK_IMAGE_RE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @androidx.annotation.Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_RE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            mUri = data.getData();
            imageView.setImageURI(mUri);

        }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, android.view.View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}