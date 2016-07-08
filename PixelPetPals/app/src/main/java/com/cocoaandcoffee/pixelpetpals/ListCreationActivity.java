package com.cocoaandcoffee.pixelpetpals;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;

public class ListCreationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_creation);

        Button b1 = (Button) findViewById(R.id.button4);
        final EditText t1 = (EditText) findViewById(R.id.editText);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = t1.getText().toString();
                Intent resultIntent = new Intent();
                resultIntent.putExtra("name", name);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });
    }


}
