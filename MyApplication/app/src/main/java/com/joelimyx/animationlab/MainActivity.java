package com.joelimyx.animationlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText input = (EditText) findViewById(R.id.input);
        Button button = (Button) findViewById(R.id.button);
        final TextView animated = (TextView) findViewById(R.id.animated);
        final ViewGroup linear = (ViewGroup) findViewById(R.id.linear);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = input.getText().toString();
                input.setText("");
                animated.setText(text);
                animated.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.endless_imaginaton));
                TextView newText = new TextView(getApplicationContext());
                newText.setText(text);
                linear.addView(newText);
                newText.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.add_text));
            }
        });
    }
}
