package com.mehedihasanbangladeshi.sdmgap.newspaperappdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView bdnews, prothomalo;
//    String mUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bdnews = findViewById(R.id.bdnews);
        prothomalo = findViewById(R.id.prothomalo);

        bdnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bdnewsIntent = new Intent(MainActivity.this, NewspaperView.class);
                String url = "https://bangla.bdnews24.com/";
                bdnewsIntent.putExtra("url", url);
                startActivity(bdnewsIntent);
            }
        });

prothomalo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent prothomaloIntent = new Intent(MainActivity.this, NewspaperView.class);
                String url = "https://prothomalo.com";
                prothomaloIntent.putExtra("url", url);
                startActivity(prothomaloIntent);
            }
        });


    }
}
