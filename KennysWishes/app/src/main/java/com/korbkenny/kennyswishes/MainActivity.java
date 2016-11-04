package com.korbkenny.kennyswishes;

import android.animation.LayoutTransition;
import android.os.Handler;
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

    EditText mEditText;
    TextView mMiddleText;
    Button mAddWish;
    ViewGroup mViewGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.edit_text);
        mMiddleText = (TextView) findViewById(R.id.middle_text);
        mAddWish = (Button) findViewById(R.id.add_button);
        mViewGroup = (ViewGroup) findViewById(R.id.layout_list);

        LayoutTransition l = new LayoutTransition();
        l.enableTransitionType(LayoutTransition.CHANGING);
        mViewGroup.setLayoutTransition(l);

        mAddWish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditText.setEnabled(false);
                mMiddleText.setText("Your wish is being granted...");

                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.middle_text_animate_part_one);
                mMiddleText.startAnimation(animation);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String wishText = mEditText.getText().toString();
                        mMiddleText.setText(wishText);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mViewGroup.addView(new TextView(MainActivity.this),0);
                                TextView wish = (TextView) mViewGroup.getChildAt(0);
                                wish.setText(mMiddleText.getText());
                                mEditText.setEnabled(true);
                                mMiddleText.setText("");
                                mEditText.setText("");
                            }
                        }, 1500);
                    }
                }, 3300);


            }
        });





    }
}
