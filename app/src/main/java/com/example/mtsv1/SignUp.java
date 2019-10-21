package com.example.mtsv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mtsv1.Model.User;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUp extends AppCompatActivity {

    EditText edtPhone,edtPassword,edtName,edtHostelId,edtMessNo,edtRoomNo;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edtName = (EditText)findViewById(R.id.edtName);

        edtPhone = (EditText)findViewById(R.id.edtPhone);

        edtPassword = (EditText)findViewById(R.id.edtPassword);

        edtHostelId = (EditText)findViewById(R.id.edtHostelId);

        edtMessNo = (EditText)findViewById(R.id.edtMessNo);

        btnSignUp = (Button)findViewById(R.id.btnSignUp);

        edtRoomNo = (EditText)findViewById(R.id.edtRoomNo);


        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog = new ProgressDialog(SignUp.this);
                mDialog.setMessage("please wait....");
                mDialog.show();
                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if(dataSnapshot.child(edtPhone.getText().toString()).exists()){

                            mDialog.dismiss();
                            finish();


                        }
                        else{

                            mDialog.dismiss();

                            User user = new User(edtHostelId.getText().toString(),edtMessNo.getText().toString(),edtName.getText().toString(),edtPassword.getText().toString(),edtRoomNo.getText().toString());
                            table_user.child(edtPhone.getText().toString()).setValue(user);
                            Toast.makeText(SignUp.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                            Intent dashboard =  new Intent(SignUp.this,Dashboard.class);
                            startActivity(dashboard);
                            finish();

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

    }
}
