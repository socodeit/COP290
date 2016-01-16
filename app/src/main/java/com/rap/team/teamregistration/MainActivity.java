package com.rap.team.teamregistration;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mysound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mysound = MediaPlayer.create(this, R.raw.bgm);
        mysound.start();

        Button acceptbutton = (Button) findViewById(R.id.acceptbuttom);
        acceptbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), com.rap.team.teamSize.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}
