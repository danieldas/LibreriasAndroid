package com.das.daniel.glide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

  //  ImageView _imgGif;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView _imgGif= (ImageView) findViewById(R.id.imgGif);
        Glide.with(this).load("https://media.giphy.com/media/xTg8BcAQSa3d36C0ec/giphy.gif")
                .asGif().centerCrop().placeholder(R.drawable.img_carga).into(_imgGif);
    }
}
