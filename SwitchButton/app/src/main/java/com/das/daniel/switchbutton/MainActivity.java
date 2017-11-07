package com.das.daniel.switchbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import lib.kingja.switchbutton.SwitchMultiButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Texto mediante strings
        SwitchMultiButton mSwitchMultiButton = (SwitchMultiButton) findViewById(R.id.switchmultibutton);
        mSwitchMultiButton.setOnSwitchListener(new SwitchMultiButton.OnSwitchListener() {
            @Override
            public void onSwitch(int position, String tabText) {
                Toast.makeText(MainActivity.this, tabText, Toast.LENGTH_SHORT).show();
            }
        });

        //Texto mediante Java
        SwitchMultiButton mSwitchMultiButton1 = (SwitchMultiButton) findViewById(R.id.switchmultibutton1);
        mSwitchMultiButton1.setText("Muy bien", "Bien", "Regular", "Mal", "Muy mal")
                .setOnSwitchListener(new SwitchMultiButton.OnSwitchListener() {
            @Override
            public void onSwitch(int position, String tabText) {
                Toast.makeText(MainActivity.this, tabText, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
