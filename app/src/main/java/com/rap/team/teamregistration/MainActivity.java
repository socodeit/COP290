package com.rap.team.teamregistration;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.rap.team.teamregistration.R;
import com.rap.team.teamSize;

public class MainActivity extends AppCompatActivity {


    MediaPlayer mysound;                                // Object for playing sound in background

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mysound = MediaPlayer.create(this, R.raw.bgm);
        mysound.start();                                //Sound starts

        //Accept button moves to next activity
        Button acceptbutton = (Button) findViewById(R.id.acceptbuttom);
        acceptbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), teamSize.class);
                startActivityForResult(intent, 0);
            }
        });

        //Command to kill all activities as a result of pressing self destruct
        if (getIntent().getBooleanExtra("Exit", false)){
            finish();
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }
}
