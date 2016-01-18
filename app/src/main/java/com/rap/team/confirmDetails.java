package com.rap.team;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.rap.team.teamregistration.R;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class confirmDetails extends AppCompatActivity {

    //private RequestQueue requestQueue =Volley.newRequestQueue(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_details);

        Intent preActivity = getIntent();
        Bundle detail = preActivity.getExtras();
        final Map<String,String> params = new HashMap<>();
        final TextView teamName = (TextView)findViewById(R.id.teamName);
        final TextView name1=(TextView)findViewById(R.id.agent1name);
        final TextView name2=(TextView)findViewById(R.id.agent2name);
        final TextView name3=(TextView)findViewById(R.id.agent3name);
        final TextView entry1=(TextView)findViewById(R.id.agent1entryno);
        final TextView entry2 = (TextView) findViewById(R.id.agent2entryno);
        final TextView entry3 = (TextView) findViewById(R.id.agent3entryno);


        teamName.setText(detail.getString("teamname"));
        name1.setText(detail.getString("name1"));
        name2.setText(detail.getString("name2"));
        entry1.setText(detail.getString("entry1"));
        entry2.setText(detail.getString("entry2"));

        params.put("teamname",detail.getString("teamname"));
        params.put("name1",detail.getString("name1"));
        params.put("entry1",detail.getString("entry1"));
        params.put("name2",detail.getString("name2"));
        params.put("entry2",detail.getString("entry2"));

        if (detail.getInt("teamsize") == 3) {
            TextView agent3 = (TextView) findViewById(R.id.agent3);
            name3.setText(detail.getString("name3"));
            entry3.setText(detail.getString("entry3"));
            agent3.setText("AGENT 3");

            params.put("name3",detail.getString("name3"));
            params.put("entry3",detail.getString("entry3"));
        }


        final String url = "http://agni.iitd.ernet.in/cop290/assign0/register/";
        final RequestQueue requestQueue =Volley.newRequestQueue(this);

        final JSONObject data = new JSONObject(params);
        Toast.makeText(getApplicationContext(),data.toString(),Toast.LENGTH_LONG).show();

        Button confirmButton  = (Button)findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringRequest stringRequest = new StringRequest(Request.Method.POST,url,new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {


                        if (response.equals("{\"RESPONSE_SUCCESS\": 1, \"RESPONSE_MESSAGE\": \"Registration completed\"}")) {
                            Intent nextActivity = new Intent(confirmDetails.this, status.class);
                            startActivity(nextActivity);
                        } else if (response.equals("{\"RESPONSE_SUCCESS\": 0, \"RESPONSE_MESSAGE\": \"User already registered\"}")) {
                            Toast.makeText(getApplicationContext(), "User Already Registered", Toast.LENGTH_SHORT).show();
                        } else if (response.equals("{\"RESPONSE_SUCCESS\": 0, \"RESPONSE_MESSAGE\": \"Data not posted!\"}")) {
                            Toast.makeText(getApplicationContext(), "Data not posted!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Something went wrong -101", Toast.LENGTH_SHORT).show();
                        }
                    }

                },new Response.ErrorListener(){

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
                    }

                }){
                    @Override
                    protected Map<String,String> getParams(){
                        return params;
                    }
                };
                requestQueue.add(stringRequest);
            }
        });
    }

}
