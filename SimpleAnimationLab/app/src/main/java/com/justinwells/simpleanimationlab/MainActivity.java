package com.justinwells.simpleanimationlab;

import android.animation.LayoutTransition;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ViewGroup wishList;
    private ImageView addWish, kazaam;
    private EditText wish;
    private TextView wishText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LayoutTransition layoutTransition = new LayoutTransition();
        layoutTransition.enableTransitionType(LayoutTransition.CHANGING);
        wishList = (ViewGroup) findViewById(R.id.wish_list);
        wishList.setLayoutTransition(layoutTransition);

        wish = (EditText) findViewById(R.id.make_a_wish);

        wishText = (TextView) findViewById(R.id.wish_text);

        kazaam = (ImageView) findViewById(R.id.wish_button);

        addWish = (ImageView) findViewById(R.id.wish_button);
        addWish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kazaam.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.appear));

                String newWish = wish.getText().toString();
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
                wishText.setText(newWish);
                wishText.startAnimation(animation);


                TextView temp = new TextView(getApplicationContext());
                        temp.setText(newWish);
                wishList.addView(temp,0);
                wishList.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.appear));
            }
        });
    }
}
