package com.example.activity_list_view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class user_image extends AppCompatActivity {
    CircleImageView image;
    TextView name,message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_image);
        image=findViewById(R.id.profileimage);
        name=findViewById(R.id.myname);
        message=findViewById(R.id.mymessage);
        Intent intent=getIntent();
        String uname=intent.getStringExtra("name");
        String umessage=intent.getStringExtra("message");
        int uimage= intent.getIntExtra("image",R.drawable.banana);
        name.setText(uname);
        message.setText(umessage);
        image.setImageResource(uimage);


    }
}