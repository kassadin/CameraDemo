package vip.kassadin.camerademo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SurfaceViewActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, SurfaceViewActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DemoSurfaceView(this));
    }
}
