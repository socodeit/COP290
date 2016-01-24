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
import android.widget.Toast;

import com.rap.team.teamregistration.R;

public class teamSize extends AppCompatActivity {
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_size);
        rg = (RadioGroup) findViewById(R.id.radioGroup); //using radiobutton to choose team s ize
        Button next = (Button) findViewById(R.id.buttonsize);
        next.setOnClickListener(new View.OnClickListener() {         //defining what to do when next button is pressed
            @Override
            public void onClick(View v) {
                int a=2;
              RadioButton r=(RadioButton)findViewById(rg.getCheckedRadioButtonId());
                //changing value of in a according to team size chosen
                if(r.getText().equals("3 AGENTS"))
                {
                    a = 3;
                }
                // creating bundle to pass team name and team size details
                Bundle bundle =new Bundle();
                EditText nameField = (EditText) findViewById(R.id.teamnam);
                Editable editable = nameField.getText();
                String name = editable == null ? "" : editable.toString();
                String err="";
                //checking if team name is not entered and next button is pressed then showing toast message to fill team name box
                if(name.equals("")) {
                    err += "Team Name can't be empty..!\n";
                    Toast.makeText(getApplicationContext(), err, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //if everything is fine then putting team name and size in bundle
                bundle.putString("teamname",name);
                bundle.putInt("teamsize",a);
                bundle.putInt("currentmember",1);
                    //creating intent to open enterdetail as next page
                Intent intent = new Intent(teamSize.this, com.rap.team.enterDetail.class);
                    //putting bundle in intent
                intent.putExtras(bundle);
                    //opening next(enterdetail) page
                startActivity(intent);
                }
            }
        });
    }
}





