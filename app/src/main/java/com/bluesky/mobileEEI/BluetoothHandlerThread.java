package com.bluesky.mobileEEI;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import static android.content.ContentValues.TAG;

/**
 * Created by Joseph on 1/25/2018.
 */

public class BluetoothHandlerThread extends Thread {
    private final BluetoothSocket mmSocket;
    private final BluetoothDevice mmDevice;
    private static final UUID MY_UUID =UUID.fromString("be1f833d-037a-41c9-9fb5-54166e3799ab");
    private Context context;
    public BluetoothHandlerThread(BluetoothDevice device, Context context) {
        // Use a temporary object that is later assigned to mmSocket
        // because mmSocket is final.
        BluetoothSocket tmp = null;
        mmDevice = device;
        this.context = context;

        try {
            // Get a BluetoothSocket to connect with the given BluetoothDevice.
            // MY_UUID is the app's UUID string, also used in the server code.
            tmp = device.createRfcommSocketToServiceRecord(MY_UUID);
        } catch (IOException e) {
            Log.e(TAG, "Socket's create() method failed", e);
        }
        mmSocket = tmp;
    }

    public void run() {
        try {
            // Connect to the remote device through the socket. This call blocks
            // until it succeeds or throws an exception.
            mmSocket.connect();
            this.receiveData();
            mmSocket.close();
        } catch (IOException connectException) {
            // Unable to connect; close the socket and return.
            try {
                mmSocket.close();
            } catch (IOException closeException) {
                Log.e(TAG, "Could not close the client socket", closeException);
            }
        }
    }

    private void receiveData() {
        try {
            InputStream input = mmSocket.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(input);

            File file = new File(context.getFilesDir(), "test.yaml");
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);

            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                try {
//                    int bytesRead = -1;
//                    String message = "";
//                    if (bis.available() > 0) {
//                        bytesRead = bis.read(buffer);
//                        if (bytesRead > 0) {
//                            while ((bytesRead == bufferSize) && (buffer[bufferSize - 1] != 0)) {
//                                message = message + new String(buffer, 0, bytesRead);
//                                bytesRead = input.read(buffer);
//                            }
//                            if((buffer[bytesRead - 1] != 0)) {
//                                message = message + new String(buffer, 0, bytesRead);
//                            } else {
//                                message = message + new String(buffer, 0, bytesRead - 1);
//                            }
                            fos.write(buffer, 0, bytesRead);
//                            i++;
//                        } else {
//                            fos.close();
//                            bis.close();
//                            input.close();
//                            break;
//                        }
                    }
                 catch (IOException e) {
                    fos.close();
                    bis.close();
                    input.close();
                    Log.e(TAG, "disconnected", e);
                    break;
                }
            }
            fos.close();
            bis.close();
            input.close();
//            return;
        } catch (IOException inputException) {
            // Unable to get input stream.
        }
    }

    // Closes the client socket and causes the thread to finish.
    public void cancel() {
        try {
            mmSocket.close();
        } catch (IOException e) {
            Log.e(TAG, "Could not close the client socket", e);
        }
    }
}