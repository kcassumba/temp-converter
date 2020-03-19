package com.example.tempconvert;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class ColorActivity extends AppCompatActivity {
    private RadioButton yellowButton;
    private RadioButton pinkButton;
    private RadioButton cyanButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        yellowButton = findViewById(R.id.yellowButton);
        pinkButton = findViewById(R.id.pinkButton);
        cyanButton = findViewById(R.id.cyanButton);
        //makes sure that the correct button is pressed when you go back to the
        Intent i = getIntent();
        int color = i.getIntExtra("COLOR", 0xffffffff);
        if(color == 0xffffff00){
            yellowButton.setChecked(true);
        }else if (color == 0xffffc0cb){
            pinkButton.setChecked(true);
        }else{
            cyanButton.setChecked(true);
        }
    }

    @Override
    public void onBackPressed(){

        int color;
        if(yellowButton.isChecked()){
            color = 0xffffff00;
        }else if(pinkButton.isChecked()){
            color = 0xffffc0cb;
        }else{
            color = 0xff00ffff;
        }
        //we want to send the color back to the main activity to then change the background color
        Intent i = new Intent();
        //store data in an intent(label for data, data);
        //label we put is "color" so we can retrieve it later
        i.putExtra("COLOR", color);
        setResult(RESULT_OK, i);
        finish();
    }



}