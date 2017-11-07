package com.das.daniel.shareable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.robertsimoes.shareable.Shareable;

public class MainActivity extends AppCompatActivity {

    Button _btnFacebook, _btnTwitter, _btnGoogle, _btnCompartir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _btnFacebook= (Button) findViewById(R.id.btnFacebook);
        _btnTwitter= (Button) findViewById(R.id.btnTwitter);
        _btnGoogle= (Button) findViewById(R.id.btnGoogle);
        _btnCompartir= (Button) findViewById(R.id.btnCompartir);

        _btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Shareable shareAction = new Shareable.Builder(MainActivity.this)
                        .message("Este es mi mensaje para Facebook")
                        .url("http://www.gdg.androidbolivia.com/")
                        .socialChannel(Shareable.Builder.FACEBOOK)
                        .build();
                shareAction.share();
            }
        });

        _btnTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Shareable shareAction = new Shareable.Builder(MainActivity.this)
                        .message("Este es mi mensaje para Twitter")
                        .url("http://www.gdg.androidbolivia.com/")
                        .socialChannel(Shareable.Builder.TWITTER)
                        .build();
                shareAction.share();
            }
        });

        _btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Shareable shareAction = new Shareable.Builder(MainActivity.this)
                        .message("Este es mi mensaje para Google Plus")
                        .url("http://www.gdg.androidbolivia.com/")
                        .socialChannel(Shareable.Builder.GOOGLE_PLUS)
                        .build();
                shareAction.share();
            }
        });

        _btnCompartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Shareable shareAction = new Shareable.Builder(MainActivity.this)
                        .message("Este es mi mensaje para Compartir")
                        .url("http://www.gdg.androidbolivia.com/")
                        .socialChannel(Shareable.Builder.ANY)
                        .build();
                shareAction.share();
            }
        });
    }
}
