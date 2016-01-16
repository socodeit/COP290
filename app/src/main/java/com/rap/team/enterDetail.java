package com.rap.team;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.text.Editable;
import android.widget.TextView;

import com.rap.team.teamregistration.R;

public class enterDetail extends AppCompatActivity {
    Bundle detail;
    int currentMember = 1;      //Member whose detail is going to be entered
    int teamSize=3;
    public void nextAgent(View view)
    {
        Intent nextActivityBundle;
        if(currentMember == teamSize)
            nextActivityBundle = new Intent(this,status.class);
        else
            nextActivityBundle = new Intent(this,enterDetail.class);

        EditText nameField=(EditText)findViewById(R.id.name);
        Editable editable = nameField.getText();
        String name = editable == null ? "" : editable.toString();

        EditText entrynoField=(EditText)findViewById(R.id.entryno);
        editable = entrynoField.getText();
        String entryno = editable == null ? "" : editable.toString();


        detail.putInt("currentmember",currentMember+1);
        detail.putString("name"+Integer.toString(currentMember),name);
        detail.putString("entryno"+Integer.toString(currentMember),entryno);

        nextActivityBundle.putExtras(detail);

        startActivity(nextActivityBundle);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_detail);

        Intent intent = getIntent();
        detail = intent.getExtras();

        currentMember = detail.getInt("currentmember");
        teamSize = detail.getInt("teamsize");

        TextView heading = (TextView)findViewById(R.id.enterDetailHead);
        heading.setText("AGENT "+Integer.toString(currentMember));

    }
}
