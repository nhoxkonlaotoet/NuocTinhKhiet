package com.example.administrator.nuoctinhkhiet.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.administrator.nuoctinhkhiet.Models.Account;
import com.example.administrator.nuoctinhkhiet.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    FirebaseStorage mStorage = FirebaseStorage.getInstance();

    int REQUEST_CODE_IMAGE =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btn =(Button) findViewById(R.id.btnLogin);

        DatabaseReference AccountRef = myRef.child("Account");
       //Map<String, Account> acc= new HashMap<String,Account>();
        List<Account> acc=new ArrayList<>();
       // acc.put("012335835",new Account("012335835","123456", 1,"Còn hoạt động", "1/1/2017" ));
       // acc.put("01633580156",new Account("01633580156","123456", 0,"Còn hoạt động", "1/1/2017" ));

        acc.add(new Account("012335835","123456", 1,"Còn hoạt động", "1/1/2017" ));
        acc.add(new Account("01633580156","123456", 0,"Còn hoạt động", "1/1/2017" ));
        //aaaaaaaaaaaaaaaa
        AccountRef.setValue(acc);
        Query query1 = myRef.child("Product").orderByChild("typeid").equalTo(1);
        Query query = myRef.child("Product").orderByChild("typeid");

        final StorageReference storageRef = mStorage.getReference();

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();

                // push lên storage
//                StorageReference mountainsRef = storageRef.child("mountains.jpg");
//                imgv.setDrawingCacheEnabled(true);
//                imgv.buildDrawingCache();
//                Bitmap bitmap = imgv.getDrawingCache();
//                ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
//                byte[] data = baos.toByteArray();
//
//                UploadTask uploadTask = mountainsRef.putBytes(data);
//                uploadTask.addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception exception) {
//                        // Handle unsuccessful uploads
//                        Toast.makeText(LoginActivity.this, "fail", Toast.LENGTH_SHORT).show();
//                    }
//                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                    @Override
//                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                        Toast.makeText(LoginActivity.this, "OKKKK", Toast.LENGTH_SHORT).show();
//                    }
//                });
            }
        });


        AccountRef.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //    Map<Integer, Account> mapObj = (Map<Integer, Account>)  dataSnapshot.getValue();
            //    Collection<Account> lstAcc = (ArrayList<Account>) dataSnapshot.getValue();

                Log.e("lambda",""+dataSnapshot.getValue());



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                    Log.e("where", ""+dataSnapshot.getValue());
                for(final DataSnapshot product:dataSnapshot.getChildren())
                {
                    String typeid= product.child("typeid").getValue().toString();
                    Log.e("child",""+ typeid); // lấy ra mã loại
                    Query queryjoin = myRef.child("Productype").orderByChild("typeid").equalTo(Integer.parseInt(typeid));
                    queryjoin.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            Log.e("join", ""+product+"     "+dataSnapshot.getValue());
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }



}

