package com.oo.hellojni;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
//        tv.setText(stringFromJNI());
        Random random = new Random();
        int x = random.nextInt(10);
        int y = random.nextInt(8);
        StringBuilder builder = new StringBuilder();
        builder.append("x=" + x + ",y=" + y +"\n");
        builder.append("x+y=" + add(x, y) + "\n");
        builder.append("x-y=" + sub(x, y) + "\n");
        builder.append("x*y=" + mul(x, y) + "\n");
        if (y > 0) {
            builder.append("x/y=" + dev(x, y) + "\n");
        }

        tv.setText(builder.toString());
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    public native String showName();

    public native int add(int a, int b);

    public native int sub(int a, int b);

    public native int mul(int a, int b);

    public native int dev(int a, int b);
}
