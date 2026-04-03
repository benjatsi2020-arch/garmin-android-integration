// USBManager.java
// USB communication handler

package com.garmin.android;
import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;
import java.util.HashMap;

public class USBManager {
    private Context context;
    private UsbManager usbManager;
    private UsbDevice garminDevice;
    private UsbDeviceConnection connection;

    public USBManager(Context context) {
        this.context = context;
        this.usbManager = (UsbManager) context.getSystemService(Context.USB_SERVICE);
    }

    public void findGarminDevice() {
        HashMap<String, UsbDevice> deviceList = usbManager.getDeviceList();
        for (UsbDevice device : deviceList.values()) {
            // Garmin device ID (example: 0x091E)
            if (device.getVendorId() == 0x091E) {
                garminDevice = device;
                break;
            }
        }
    }

    public void connectDevice() {
        if (garminDevice != null) {
            connection = usbManager.openDevice(garminDevice);
        }
    }

    public void disconnectDevice() {
        if (connection != null) {
            connection.close();
        }
    }
}