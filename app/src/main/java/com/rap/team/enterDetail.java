package com.rap.team;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.text.Editable;
import android.widget.TextView;
import android.widget.Toast;

import com.rap.team.teamregistration.R;

public class enterDetail extends AppCompatActivity {
    Bundle detail;
    int currentMember = 1;      //Member whose detail is going to be entered
    int teamSize = 3;

    //    public void nextAgent(View view)
//    {
//        Intent nextActivityBundle;
//        if(currentMember == teamSize)
//            nextActivityBundle = new Intent(this,status.class);
//        else
//            nextActivityBundle = new Intent(this,enterDetail.class);
//
//        EditText nameField=(EditText)findViewById(R.id.name);
//        Editable editable = nameField.getText();
//        String name = editable == null ? "" : editable.toString();
//
//        EditText entrynoField=(EditText)findViewById(R.id.entryno);
//        editable = entrynoField.getText();
//        String entryno = editable == null ? "" : editable.toString();
//
//
//        detail.putInt("currentmember",currentMember+1);
//        detail.putString("name"+Integer.toString(currentMember),name);
//        detail.putString("entryno"+Integer.toString(currentMember),entryno);
//
//        nextActivityBundle.putExtras(detail);
//
//        startActivity(nextActivityBundle);
//
//    }

    int isEntryNo(String entry)
    {
        int year=0;

        if(entry.length() != 13 || entry.length() != 11)
            return -1;

        for(int i=0;i<4;i++)
        {
            if(!Character.isDigit(entry.charAt(i)))
                return -1;
            else
                year  = year*10 + entry.charAt(i)-'0';
        }

        for(int i=0;i<2;i++)
        {
            if(!Character.isLetter(entry.charAt(i+4)))
                return -1;
        }

        if(entry.length()==11) {
            for(int i=0;i<5;i++)
            {
                if(!Character.isDigit(entry.charAt(i+6)))
                    return -1;
            }
        }
        else if(entry.length()==13)
        {
            if(!Character.isLetter(entry.charAt(6))) return -1;

            for(int i=0;i<5;i++)
            {
                if(!Character.isDigit(entry.charAt(i+7)))
                    return -1;
            }
        }

        if(year > 2015 || year < 2007)
            return -2;
        else
            return 1;//Success
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_detail);

        Intent intent = getIntent();

        detail = intent.getExtras();
            currentMember = detail.getInt("currentmember");
            teamSize = detail.getInt("teamsize");
        TextView heading = (TextView) findViewById(R.id.enterDetailHead);
        heading.setText("AGENT " + Integer.toString(currentMember));


        final Button button = (Button) findViewById(R.id.nextButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText nameField = (EditText) findViewById(R.id.name);
                Editable editable = nameField.getText();
                String name = editable == null ? "" : editable.toString();

                EditText entrynoField = (EditText) findViewById(R.id.entryno);
                editable = entrynoField.getText();
                String entryno = editable == null ? "" : editable.toString();

                if(isEntryNo(entryno)==1 || !name.equals("")) {

                    Intent nextActivityBundle;
                    if (currentMember == teamSize)
                        nextActivityBundle = new Intent(enterDetail.this, confirmDetails.class);
                    else
                        nextActivityBundle = new Intent(enterDetail.this, enterDetail.class);

                    detail.putInt("teamsize", teamSize);
                    detail.putInt("currentmember", currentMember + 1);
                    detail.putString("name" + Integer.toString(currentMember), name);
                    detail.putString("entry" + Integer.toString(currentMember), entryno);

                    nextActivityBundle.putExtras(detail);
                    startActivity(nextActivityBundle);

                }
                else
                {
                    String error="";
                    if(name.equals(""))
                        error+="Name can't empty..!\n";
                    if(isEntryNo(entryno)==-1)
                        error+="Entry No. format is incorrect.";
                    else if(isEntryNo(entryno)==-2)
                        error+="Invalid Year in Entry No.";

                    Toast.makeText(getApplicationContext(),error,Toast.LENGTH_SHORT);
                }
            }
        });
    }
}
