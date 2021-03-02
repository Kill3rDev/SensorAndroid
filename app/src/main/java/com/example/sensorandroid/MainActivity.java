package com.example.sensorandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private Sensor mSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



            sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

            java.util.List<Sensor> deviceSensors = sensorManager.getSensorList(Sensor.TYPE_ALL);


            sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
            if (sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null){

            } else {

            }


            sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
            mSensor = null;

            if (sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY) != null){
                List<Sensor> gravSensors = sensorManager.getSensorList(Sensor.TYPE_GRAVITY);
                for(int i=0; i<gravSensors.size(); i++) {
                    if ((gravSensors.get(i).getVendor().contains("Google LLC")) &&
                            (gravSensors.get(i).getVersion() == 3)){
                        mSensor = gravSensors.get(i);
                    }
                }
            }
            if (mSensor == null){

                if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null){
                    mSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
                } else{

                }
            }
    }
}