package com.example.tempconvert;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText fBox;
    private EditText cBox;
    private RadioButton FtoCRadio;
    private RadioButton CtoFRadio;
    private ConstraintLayout layout;
    private int color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fBox = findViewById(R.id.fBox);
        cBox = findViewById(R.id.cBox);
        layout = findViewById(R.id.layout);
        FtoCRadio = findViewById(R.id.FtoCRadio);
        CtoFRadio = findViewById(R.id.CtoFRadio);
        cBox.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                convert(v);
                return false;
            }
        });

        fBox.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                convert(v);
                return false;
            }
        });

    }

    public void colorPressed(View v){
        //a means for the two activities to talk to each other
        //we are not sending any information here but we just want the two to connect
        Intent i = new Intent(this, ColorActivity.class);
        i.putExtra("COLOR", color);

        //startActivity(intent) - you dont want information back
        // startActivityForResult(i, 1)- used for when getting data back
        startActivityForResult(i, 1);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        //getIntExtra - you have to specify what you are getting  int, double, string
        int color = data.getIntExtra("COLOR", 0xffffffff);
        layout.setBackgroundColor(color);

    }


    public void convert(View v){
        if(FtoCRadio.isChecked()) {

            String input = fBox.getText().toString();

            if(input.length()>0) {


                double fValue = Double.parseDouble(input);
                double cValue = (fValue - 32) * 5.0 / 9.0;
                cBox.setText(String.format("%.1f", cValue));
            }else{
                Toast.makeText(this,"No Fahrenheit value entered.", Toast.LENGTH_SHORT).show();
            }
        } else{

            String input = cBox.getText().toString();
             if(input.length()>0){

            double cValue = Double.parseDouble(input);
            double fValue =  (cValue * 9.0/5.0 ) +32;
            fBox.setText(String.format("%.1f", fValue));

             }else{
                 Toast.makeText(this,"No Celsius value entered.", Toast.LENGTH_SHORT).show();
             }

        }
    }






}
