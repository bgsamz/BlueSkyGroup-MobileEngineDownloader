package com.bluesky.mobileEEI;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bluesky.mobileEEI.R;


public class MainActivity extends AppCompatActivity {
    static String started = "starting thread";
    static String ended = "thread has joined";
    public Button connect;
    public Button parse;
    private final static int REQUEST_ENABLE_BT = 1;
    BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
    private void enableBT() {
        if (adapter == null) {
            // Device doesn't support Bluetooth
        }
        if (!adapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT );
        }
    }
    public void buttons(){
        connect = (Button)findViewById(R.id.Connect);
        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            TextView textView = (TextView) findViewById(R.id.parsedText);
            textView.setText(started);
            BluetoothDevice device = adapter.getRemoteDevice("A4:5E:60:DF:2F:B6");
            BluetoothHandlerThread mBluetoothHandlerThread = new BluetoothHandlerThread(device, getApplicationContext());
            mBluetoothHandlerThread.start();
            try {
                mBluetoothHandlerThread.join();
                textView.setText(ended);
            } catch (Exception e) {
                textView.setText(e.toString());
            }
            }
        });

        parse = (Button) findViewById(R.id.Parse);
        parse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileParser fileParser = new FileParser();
                String parsed = fileParser.run(getApplicationContext());
                TextView textView = (TextView) findViewById(R.id.parsedText);
                textView.setText(parsed);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enableBT();
        buttons();
    }
}