package com.das.daniel.smallbang;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import xyz.hanks.library.SmallBang;
import xyz.hanks.library.SmallBangListener;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton _btnAgregar;
    SmallBang mSmallBang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _btnAgregar= (FloatingActionButton) findViewById(R.id.btnAgregar);
         mSmallBang = SmallBang.attach2Window(MainActivity.this);
        _btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSmallBang.bang(view,50, new SmallBangListener() {
                    @Override
                    public void onAnimationStart() {
                    }
                    @Override
                    public void onAnimationEnd() {
                        Toast.makeText(MainActivity.this, "Botón presionado",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
