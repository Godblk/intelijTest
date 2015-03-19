package com.example.ObjectAnimator;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MyActivity extends Activity implements View.OnClickListener {
    /**
     * Called when the activity is first created.
     */
    private  ImageView iv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        iv = (ImageView) findViewById(R.id.iv);

        iv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        rotateView();
    }

    private void rotateView() {
        PropertyValuesHolder pvx = PropertyValuesHolder.ofFloat("translationX",10f,10f,10f);
        PropertyValuesHolder pvy = PropertyValuesHolder.ofFloat("scale",1f,0f,1f);
        PropertyValuesHolder pcz = PropertyValuesHolder.ofFloat("translationY",0f,10f,0f);
        ObjectAnimator.ofPropertyValuesHolder(iv,pvx,pvy,pcz).setDuration(1000).start();
    }
}
