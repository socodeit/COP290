package com.rap.team;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.rap.team.teamregistration.R;

public class teamSize extends AppCompatActivity {
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_size);
        rg = (RadioGroup) findViewById(R.id.radioGroup);
        rg.clearCheck();

        Button next = (Button) findViewById(R.id.buttonsize);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a=2;
              RadioButton r=(RadioButton)findViewById(rg.getCheckedRadioButtonId());
                if(r.getText().equals("3 AGENTS"))
                {
                    a = 3;
                }

                Bundle bundle =new Bundle();
                EditText nameField = (EditText) findViewById(R.id.teamnam);
                Editable editable = nameField.getText();
                String name = editable == null ? "" : editable.toString();
                bundle.putString("teamname",name);
                bundle.putInt("teamsize",a);
                bundle.putInt("currentmember",1);
                Intent intent = new Intent(teamSize.this, com.rap.team.enterDetail.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}





