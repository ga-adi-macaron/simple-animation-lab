package com.elysium.lab;

import android.animation.LayoutTransition;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mEditText;
    private TextView mAnimation;
    private ViewGroup mViewGroup;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.edit_text);
        mAnimation = (TextView) findViewById(R.id.animation);
        mButton = (Button) findViewById(R.id.button);

        LayoutTransition layoutTransition = new LayoutTransition();
        layoutTransition.enableTransitionType(LayoutTransition.CHANGING);

        mViewGroup = (ViewGroup) findViewById(R.id.bottom);
        mViewGroup.setLayoutTransition(layoutTransition);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = mEditText.getText().toString();

                TextView myWishList = new TextView(MainActivity.this);
                mViewGroup.addView(myWishList, 0);

                mAnimation.setText(text);
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);
                mAnimation.startAnimation(animation);

                myWishList.setText(text);
                mEditText.setText("");
            }
        });
    }
}

