// BluetoothManager.java
// Bluetooth communication handler

package com.garmin.android;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice; 
import android.bluetooth.BluetoothSocket;
import java.io.IOException;
import java.util.UUID;

public class BluetoothManager {
    private BluetoothAdapter bluetoothAdapter;
    private BluetoothSocket bluetoothSocket;
    private final UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"); // SPP UUID

    public BluetoothManager() {
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    public void connectDevice(BluetoothDevice device) throws IOException {
        bluetoothSocket = device.createRfcommSocketToServiceRecord(uuid);
        bluetoothSocket.connect();
    }

    public void disconnect() throws IOException {
        if (bluetoothSocket != null) {
            bluetoothSocket.close();
        }
    }
}