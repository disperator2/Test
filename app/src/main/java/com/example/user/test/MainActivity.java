package com.example.user.test;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor sensor;
    private TextView text;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.central_text);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, sensor, sensorManager.SENSOR_DELAY_GAME);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Power=" + String.valueOf(sensor.getPower()) + "\n");
        stringBuilder.append("ID=" + String.valueOf(sensor.getId()) + "\n");
        stringBuilder.append("Name=" + sensor.getName() + "\n");
        stringBuilder.append("MaxDelay=" + String.valueOf(sensor.getMaxDelay()) + "\n");
        stringBuilder.append("Version=" + String.valueOf(sensor.getVersion()) + "\n");

        text.setText(stringBuilder.toString());
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        textView1.setText(String.valueOf(sensorEvent.values[0]));
        textView2.setText(String.valueOf(sensorEvent.values[1]));
        textView3.setText(String.valueOf(sensorEvent.values[2]));
        ///123
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
