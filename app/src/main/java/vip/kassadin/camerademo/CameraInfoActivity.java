package vip.kassadin.camerademo;

import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.elvishew.xlog.LogLevel;
import com.elvishew.xlog.XLog;

import org.joor.Reflect;

import java.util.LinkedHashMap;
import java.util.Set;

import static android.R.attr.x;

public class CameraInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_info);
        XLog.init(BuildConfig.DEBUG ? LogLevel.ALL : LogLevel.NONE);
        int cameras = Camera.getNumberOfCameras();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int i = 0; i < cameras; i++) {
            Camera.getCameraInfo(i, cameraInfo);
            XLog.d("编号：%s", i);
            XLog.d("类型：%s",getFacing(cameraInfo.facing));
            XLog.d("关闭声音：%s", cameraInfo.canDisableShutterSound);
            XLog.d("方向：%s", cameraInfo.orientation);
            Camera camera = openCamera(i);
            if (camera != null) {
                Camera.Parameters parameters = camera.getParameters();

                LinkedHashMap<String, String> mMap = Reflect.on(parameters).get("mMap");
                if (mMap != null) {
                    for (String k : mMap.keySet()) {
                     XLog.d("dump: " + k + "=" + mMap.get(k));
                    }
                }
            }
        }
    }

    private String getFacing(int facing) {
        switch (facing) {
            case Camera.CameraInfo.CAMERA_FACING_FRONT:
                return "前置";
            case Camera.CameraInfo.CAMERA_FACING_BACK:
                return "后置";
            default:
                return "未知";
        }
    }

    public static Camera openCamera(int cameraId) {
        try{
            return Camera.open(cameraId);
        }catch(Exception e) {
            return null;
        }
    }

}
