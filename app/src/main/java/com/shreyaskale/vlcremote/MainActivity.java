package com.shreyaskale.vlcremote;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {

    //Activity handling
    EditText tv;
    EditText tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (EditText) findViewById(R.id.name);
        tv1 = (EditText) findViewById(R.id.password);

        //Listening to button event
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), Tutorial_1.class);
                startActivity(nextScreen);
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), Tutorial_2.class);
                startActivity(nextScreen);
            }
        });

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), Remote_view.class);

                //Sending data to another Activity
                nextScreen.putExtra("ip", tv.getText().toString());
                nextScreen.putExtra("pass", tv1.getText().toString());
                startActivity(nextScreen);
            }
        });
    }

    //Action Bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {
            case R.id.action_settings:
                // search action
                return true;
            case R.id.action_about_us:
                // open AboutUs activity
                AboutUs();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /*Launching new activity*/
    private void AboutUs() {
        Intent i = new Intent(MainActivity.this, AboutUs.class);
        startActivity(i);
    }
}
