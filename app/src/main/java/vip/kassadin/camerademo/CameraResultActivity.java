package vip.kassadin.camerademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class CameraResultActivity extends AppCompatActivity {

    private ImageView imageResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_result);
        imageResult = (ImageView) findViewById(R.id.image_result);
        String path = getIntent().getStringExtra("picPath");

        Glide.with(this)
             .load(path)
             .centerCrop()
             .into(imageResult);
    }
}
