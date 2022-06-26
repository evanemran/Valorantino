package com.evanemran.valorantgg.Utility;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;

public class Typewriter {
    private CharSequence mText;
    private int mIndex;
    private long mDelay = 500; //Default 500ms delay
    TextView textView;
    Context context;

    public Typewriter(TextView textView, Context context) {
        this.textView = textView;
        this.context = context;
    }

    private android.os.Handler mHandler = new Handler();
    private Runnable characterAdder = new Runnable() {
        @Override
        public void run() {
            textView.setText(mText.subSequence(0, mIndex++));
            if(mIndex <= mText.length()) {
                mHandler.postDelayed(characterAdder, mDelay);
            }
        }
    };

    public void animateText(CharSequence text) {
        mText = text;
        mIndex = 0;

        textView.setText("");
        mHandler.removeCallbacks(characterAdder);
        mHandler.postDelayed(characterAdder, mDelay);
    }

    public void setCharacterDelay(long millis) {
        mDelay = millis;
    }
}
