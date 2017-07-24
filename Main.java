package com.a23labs.room;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;



/**
 * Created by pluto on 7/10/17.
 */

public class Main extends AppCompatActivity {
    Button button1,button2,button3;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        button1 = (Button)findViewById(R.id.button1);
       // button2 = (Button)findViewById(R.id.button2);
        //button3 = (Button)findViewById(R.id.button3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start1 = new Intent(Main.this, MainActivity.class);
                startActivity(start1);
            }
        });


    }
}
