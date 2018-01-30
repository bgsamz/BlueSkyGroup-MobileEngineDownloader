package com.example.joseph.bluesky;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;




public class MainActivity extends AppCompatActivity {
    public Button connect;
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

            BluetoothDevice device = adapter.getRemoteDevice("A4:5E:60:DF:2F:B6");
            ConnectThread mConnectThread = new ConnectThread(device);
            mConnectThread.run();

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
