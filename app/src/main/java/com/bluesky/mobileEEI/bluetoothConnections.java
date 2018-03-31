package com.bluesky.mobileEEI;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.beardedhen.androidbootstrap.TypefaceProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;


/**
 * Created by Joseph on 2/3/2018.
 */

public class bluetoothConnections extends AppCompatActivity{

    private final static int REQUEST_ENABLE_BT = 1;
    BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
    public Button home;

    public ListView mainListView ;
    public ArrayAdapter listAdapter ;
    String[] devices = new String[]{"this is a test"};

    private void getPairs(){
        Set<BluetoothDevice> pairedDevices = adapter.getBondedDevices();
        listAdapter.notifyDataSetChanged();
        if (pairedDevices.size() > 0) {
            // There are paired devices. Get the name and address of each paired device.
            for (BluetoothDevice device : pairedDevices) {
                String deviceName = device.getName();
                String deviceHardwareAddress = device.getAddress();// MAC address
                String a = deviceName + ": " + deviceHardwareAddress;
                listAdapter.add(a);
                listAdapter.notifyDataSetChanged();
            }
        }
    }
    // Create a BroadcastReceiver for ACTION_FOUND.
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                // Discovery has found a device. Get the BluetoothDevice
                // object and its info from the Intent.
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                String deviceName = device.getName();
                String deviceHardwareAddress = device.getAddress();// MAC address
                String a = deviceName + ": " + deviceHardwareAddress;
                listAdapter.add(a);
                listAdapter.notifyDataSetChanged();
            }
        }
    };
    //connect to selected bt on click and return home button
    public void buttons(){
        home = (Button)findViewById(R.id.home_button);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home = (Button) findViewById(R.id.home_button);
                home.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent currentListsIntent = new Intent(bluetoothConnections.this, MainActivity.class);
                        startActivity(currentListsIntent);
                    }
                });

            }
        });
        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String device = parent.getItemAtPosition(position).toString();
                String delims = ": ";
                String tokens[] = device.split(delims, 2);
                String mac = tokens[1];


               try{ BluetoothDevice selDev = adapter.getRemoteDevice(mac);
                    BluetoothHandlerThread mConnectThread = new BluetoothHandlerThread(selDev, getApplicationContext());
                    mConnectThread.start();
                    mConnectThread.join();
               }
               catch(Exception e){
                   listAdapter.add("FAILURE");
                   listAdapter.notifyDataSetChanged();
                }

            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TypefaceProvider.registerDefaultIconSets();
        setContentView(R.layout.connect_activity);
        // Register for broadcasts when a device is discovered.
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(mReceiver, filter);


        // Find the ListView resource.
        mainListView = (ListView) findViewById( R.id.connections_list );

        ArrayList<String> itemsList = new ArrayList<>();
        itemsList.addAll( Arrays.asList(devices) );

        // Create ArrayAdapter using the item list.
        listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, itemsList);
        mainListView.setAdapter( listAdapter );

      //  getPairs();
        buttons();
    }
}


