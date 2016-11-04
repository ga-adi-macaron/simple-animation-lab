package gameshop.serkanbal.com.animationslab;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mEditText;
    Button mButton, mButton2;
    TextView mTextView;
    ViewGroup mViewGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.edittext);
        mButton = (Button) findViewById(R.id.addbutton);
        mButton2 = (Button) findViewById(R.id.delete);
        mTextView = (TextView) findViewById(R.id.textview);

        LayoutTransition l = new LayoutTransition();
        l.enableTransitionType(LayoutTransition.CHANGING);

        mViewGroup = (ViewGroup) findViewById(R.id.new_wishes);
        mViewGroup.setLayoutTransition(l);


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = mEditText.getText().toString();
                mTextView.setText(input);
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.spin_alpha);
                mTextView.startAnimation(animation);
                mEditText.setText("");
                TextView newText = new TextView(MainActivity.this);
                newText.setText(input);
                mViewGroup.addView(newText,0);
            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mViewGroup.getChildCount() != 0) {
                    mViewGroup.removeViewAt(0);
                } else {
                    Toast.makeText(MainActivity.this, "Nothing to delete dude!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
