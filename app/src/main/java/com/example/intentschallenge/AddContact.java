package com.example.intentschallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import java.util.ArrayList;

public class AddContact extends AppCompatActivity implements View.OnClickListener {
    EditText etName,etTEL,etWeb,etMap;
    ImageView ivSad,ivHappy,ivConfuse;
  //  String[] data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        etName=findViewById(R.id.etName);
        etTEL=findViewById(R.id.etTEL);
        etMap=findViewById(R.id.etMap);
        etWeb=findViewById(R.id.etWeb);

        ivConfuse=findViewById(R.id.ivConfuse);
        ivSad=findViewById(R.id.ivSad);
        ivHappy=findViewById(R.id.ivHappy);

        ivHappy.setOnClickListener(this);
        ivSad.setOnClickListener(this);
        ivConfuse.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(etMap.getText().toString().isEmpty()||etName.getText().toString().isEmpty()||etTEL.getText().toString().isEmpty()||etWeb.getText().toString().isEmpty())
        {
            Toast.makeText(AddContact.this,"FILL ALL THE FIELDS",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent intent=new Intent();
            intent.putExtra("name", etName.getText().toString().trim());
            intent.putExtra("map", etMap.getText().toString().trim());
            intent.putExtra("tel", etTEL.getText().toString().trim());
            intent.putExtra("web", etWeb.getText().toString().trim());
            if(v.getId()==R.id.ivHappy)
                intent.putExtra("mood","happy");
            else if(v.getId()==R.id.ivConfuse)
                intent.putExtra("mood","confuse");
            else
                intent.putExtra("mood","sad");


            setResult(RESULT_OK,intent);
            AddContact.this.finish();
        }
    }
}


