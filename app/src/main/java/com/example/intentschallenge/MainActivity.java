package com.example.intentschallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.Edits;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvContactApp;
    ImageView iv1,iv2,iv3,iv4;
    Button btnNewContact;
    String name,tel,web,map,mood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvContactApp=findViewById(R.id.tvContactApp);
        iv1=findViewById(R.id.iv1);
        iv1.setVisibility(View.GONE);
        iv2=findViewById(R.id.iv2);
        iv2.setVisibility(View.GONE);
        iv3=findViewById(R.id.iv3);
        iv3.setVisibility(View.GONE);
        iv4=findViewById(R.id.iv4);
        iv4.setVisibility(View.GONE);

        btnNewContact=findViewById(R.id.btnNewContact);
        btnNewContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,
                        com.example.intentschallenge.AddContact.class);
                startActivityForResult(intent,1);
            }

        });

        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 tel="tel:"+tel;
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse(tel));
                startActivity(intent);
            }
        });
        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               web="https://"+web;
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(web));
                startActivity(intent);
            }
        });
        iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  map="geo:0,0?q=:"+map;
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                startActivity(intent);
            }
        });

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent intent)
    {

        System.out.println("onActivity");
        super.onActivityResult(requestCode,resultCode,intent);
        if(requestCode==1)
        {

        if(resultCode==RESULT_OK) {
            iv1.setVisibility(View.VISIBLE);
            iv2.setVisibility(View.VISIBLE);
            iv3.setVisibility(View.VISIBLE);
            iv4.setVisibility(View.VISIBLE);

            name = intent.getStringExtra("name");
            map = intent.getStringExtra("map");
            web = intent.getStringExtra("web");
            tel = intent.getStringExtra("tel");
            mood = intent.getStringExtra("mood");
            if (mood.equals("happy"))
                iv1.setImageResource(R.drawable.ic_baseline_tag_faces_24);
            else if (mood.equals("sad"))
                iv1.setImageResource(R.drawable.ic_baseline_sentiment_very_dissatisfied_24);
            else
                iv1.setImageResource(R.drawable.confuse);
        }
        else{
            Toast.makeText(MainActivity.this,"ERROR",Toast.LENGTH_SHORT).show();
        }

        }


    }
}