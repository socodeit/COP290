package com.rap.team;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.rap.team.teamregistration.R;

public class teamSize extends AppCompatActivity {
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_size);
        rg = (RadioGroup) findViewById(R.id.radioGroup);
        rg.clearCheck();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int id) {
                {
                    RadioButton rbb = (RadioButton) group.findViewById(id);
                    if (null != rbb && id > -1) {
                        Toast.makeText(teamSize.this, rbb.getText(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        Button next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int a = rg.getCheckedRadioButtonId();
                      Bundle bundle =new Bundle();
                bundle.putInt("teamsize",a);
                bundle.putInt("currentmember",1);
                Intent intent = new Intent(teamSize.this, com.rap.team.enterDetail.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}





