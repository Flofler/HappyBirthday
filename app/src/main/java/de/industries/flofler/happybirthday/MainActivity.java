package de.industries.flofler.happybirthday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void clickButton(View view) {
        // Do something in response to button

        Intent intent = new Intent(this, DisplayReasonsActivity.class);
        startActivity(intent);
    }
}
