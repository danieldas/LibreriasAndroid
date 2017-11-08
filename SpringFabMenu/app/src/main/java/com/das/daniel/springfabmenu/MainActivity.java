package com.das.daniel.springfabmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.rany.albeg.wein.springfabmenu.SpringFabMenu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SpringFabMenu sfm = (SpringFabMenu)findViewById(R.id.sfm_1);
        sfm.setOnSpringFabMenuItemClickListener(new SpringFabMenu.OnSpringFabMenuItemClickListener() {
            @Override
            public void onSpringFabMenuItemClick(View view) {
                switch (view.getId()) {
                    case R.id.fab_Twitter:
                        Toast.makeText(MainActivity.this, "Twitter", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.fab_Facebook:
                        Toast.makeText(MainActivity.this, "Facebook", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.fab_Google:
                        Toast.makeText(MainActivity.this, "Google", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });
    }
}
