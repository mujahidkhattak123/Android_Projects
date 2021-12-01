package mechanic.mechanic_app_finder.fyp.mechanic_app;

 import android.content.Intent;
 import android.net.Uri;
 import android.widget.ImageView;
 import android.widget.Toast;

 import androidx.appcompat.app.AppCompatActivity;

 import com.bumptech.glide.Glide;
 import mechanic.mechanic_app_finder.fyp.R;
 import com.google.firebase.database.DataSnapshot;
 import com.google.firebase.database.DatabaseError;
 import com.google.firebase.database.DatabaseReference;
 import com.google.firebase.database.FirebaseDatabase;
 import com.google.firebase.database.ValueEventListener;

 public class Electrician_Details extends AppCompatActivity {
     private android.widget.TextView txt_hostelName,txt_address,txt_phoneNumber,txt_emial;
     private android.widget.TextView wifispinner, foodspinner, generatorspinner, summerroomsspinner, watercoolerspinner, watergeyserspinner,txtgender;
     private ImageView photo;

     private DatabaseReference databaseReference;

     @Override
     protected void onCreate(android.os.Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_electrician__details);

         Intent intent = getIntent();
         String iD = intent.getStringExtra("iddd");

         Toast.makeText(this, ""+iD, Toast.LENGTH_SHORT).show();



         txt_hostelName = findViewById(R.id.txt_hostelName_active_detail);
         txt_address = findViewById(R.id.txt_address_active_detail);
         txt_phoneNumber = findViewById(R.id.txt_phoneNumber_active_detail);
         txt_emial = findViewById(R.id.txt_emial_active_detail);
         wifispinner = findViewById(R.id.wifispinner_active_detail);
         foodspinner = findViewById(R.id.foodspinner_active_detail);
         generatorspinner = findViewById(R.id.generatorspinner_active_detail);
         summerroomsspinner = findViewById(R.id.summerroomsspinner_active_detail);
         watercoolerspinner = findViewById(R.id.watercoolerspinner_active_detail);
         watergeyserspinner = findViewById(R.id.watergeyserspinner_active_detail);
         txtgender = findViewById(R.id.gender_active_detail);
         photo = findViewById(R.id.imageView_active_detail);


         databaseReference= FirebaseDatabase.getInstance().getReference().child("Electrician Details");

         databaseReference.child(iD).addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(@androidx.annotation.NonNull DataSnapshot snapshot) {

//                hostel_name, address, phoneNumber, email,gender,imageUri,
//                        wifiValue,foodValue,electricValue,summerroomValue,electronicValue,eleValue
//

                 String name = (String) snapshot.child("hostel_name").getValue().toString().trim();
                 String address = (String) snapshot.child("address").getValue().toString().trim();
                 String phoneNumber = (String) snapshot.child("phoneNumber").getValue().toString().trim();
                 String email = (String) snapshot.child("email").getValue().toString().trim();
                 String gender = (String) snapshot.child("gender").getValue().toString().trim();
                 String imageUri = (String) snapshot.child("imageUri").getValue().toString().trim();
                 String wifiValue = (String) snapshot.child("wifiValue").getValue().toString().trim();
                 String foodValue = (String) snapshot.child("foodValue").getValue().toString().trim();
                 String electricValue = (String) snapshot.child("electricValue").getValue().toString().trim();
                 String summerroomValue = (String) snapshot.child("summerroomValue").getValue().toString().trim();
                 String electronicValue = (String) snapshot.child("electronicValue").getValue().toString().trim();
                 String eleValue = (String) snapshot.child("eleValue").getValue().toString().trim();


                 txt_hostelName.setText(name);
                 txt_address.setText(address);
                 txt_phoneNumber.setText(phoneNumber);
                 txt_emial.setText(email);
                 txtgender.setText(gender);
                 wifispinner.setText(wifiValue);
                 foodspinner.setText(foodValue);
                 generatorspinner.setText(electricValue);
                 summerroomsspinner.setText(summerroomValue);
                 watercoolerspinner.setText(electronicValue);
                 watergeyserspinner.setText(eleValue);
                 Glide.with(photo.getContext()).load(imageUri).placeholder(R.drawable.ic_launcher_foreground).into(photo);



                 System.out.println("+++++++++++++++++++++++++++++++++++++============="+name+"=========");
             }

             @Override
             public void onCancelled(@androidx.annotation.NonNull DatabaseError error) {

             }
         });

         txt_phoneNumber.setOnClickListener(new android.view.View.OnClickListener() {
             @Override
             public void onClick(android.view.View view) {
                 Intent intent = new Intent(Intent.ACTION_DIAL);
                 intent.setData(Uri.parse("tel:" + txt_phoneNumber.getText().toString().trim()));
                 startActivity(intent);
             }
         });

     }
 }