package com.rap.team;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rap.team.teamregistration.R;

import org.w3c.dom.Text;

public class confirmDetails extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_details);

        TextView name1=(TextView)findViewById(R.id.agent1name);
        TextView name2=(TextView)findViewById(R.id.agent2name);
        TextView name3=(TextView)findViewById(R.id.agent3name);
        TextView entry1=(TextView)findViewById(R.id.agent1entryno);
        TextView entry2=(TextView)findViewById(R.id.agent2entryno);
        TextView entry3=(TextView)findViewById(R.id.agent3entryno);

        Intent preActivity = getIntent();
        Bundle detail = preActivity.getExtras();
        name1.setText(detail.getString("name1"));
        name2.setText(detail.getString("name2"));
        name3.setText(detail.getString("name3"));
        entry1.setText(detail.getString("entry1"));
        entry2.setText(detail.getString("entry2"));
        entry3.setText(detail.getString("entry3"));

        Button confirmButton  = (Button)findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(confirmDetails.this,status.class);
                startActivity(nextActivity);
            }
        });
    }

}
