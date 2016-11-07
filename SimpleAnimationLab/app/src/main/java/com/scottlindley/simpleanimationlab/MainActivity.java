package com.scottlindley.simpleanimationlab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mWishEdit;
    private Button mAddWishButton;
    private TextView mWishText;
    private LinearLayout mWishViewGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWishEdit = (EditText)findViewById(R.id.wish_edit_text);
        mAddWishButton = (Button)findViewById(R.id.add_wish_button);
        mWishText = (TextView)findViewById(R.id.wish_text);
        mWishViewGroup = (LinearLayout)findViewById(R.id.wish_view_group);

        mAddWishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wishInput = mWishEdit.getText().toString();
                if(!wishInput.equals("")){
                    mWishText.setText(wishInput);

                    TextView viewToAdd = new TextView(MainActivity.this);
                    viewToAdd.setText(wishInput);
                    viewToAdd.setTextSize(18);

                    Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_wish);
                    mWishText.startAnimation(animation);
                    mWishViewGroup.addView(viewToAdd, 0);
                    mWishEdit.setText("");
                }else{
                    mWishEdit.setError("Wish cannot be blank");
                }
            }
        });
    }

    @Override
    protected void onPause() {

        super.onPause();
    }
}
