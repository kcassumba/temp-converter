package com.example.tempconvert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText fBox;
    private EditText cBox;
    private RadioButton FtoCRadio;
    private RadioButton CtoFRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fBox = findViewById(R.id.fBox);
        cBox = findViewById(R.id.cBox);
        FtoCRadio = findViewById(R.id.FtoCRadio);
        CtoFRadio = findViewById(R.id.CtoFRadio);

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
