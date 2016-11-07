package com.ezequielc.simpleanimationlab;

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
    private Button mButton;
    private ViewGroup mViewGroup;
    private TextView mAnimationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.edit_text);
        mButton = (Button) findViewById(R.id.button);
        mAnimationText = (TextView) findViewById(R.id.animation_text);

        LayoutTransition layoutTransition = new LayoutTransition();
        layoutTransition.enableTransitionType(LayoutTransition.CHANGING);
        mViewGroup = (ViewGroup) findViewById(R.id.bottom_linear);
        mViewGroup.setLayoutTransition(layoutTransition);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = mEditText.getText().toString();
                /*
                * Breaking down ViewGroup:
                Instead of mViewGroup.addView(new TextView(MainActivity.this, 0);
                Created variable wishList as new TextView
                (wishList, 0) adds the new TextView at index 0 which is at the top
                 */
                TextView wishList = new TextView(MainActivity.this);
                mViewGroup.addView(wishList, 0);

                mAnimationText.setText(text);
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this,
                        R.anim.alpha_rotate);
                mAnimationText.startAnimation(animation);
                wishList.setText(text);

                // Input field get cleared after a wish is added to the list
                mEditText.setText("");
            }
        });
    }
}
