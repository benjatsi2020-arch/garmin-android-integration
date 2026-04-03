// WiFiManager.java
// WiFi communication handler

package com.garmin.android;
import android.content.Context;
import android.net.wifi.WifiManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class WiFiManager {
    private Context context;
    private WifiManager wifiManager;
    private Socket socket;
    private String garminIP;
    private int garminPort = 9001; // Default Garmin port

    public WiFiManager(Context context) {
        this.context = context;
        this.wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
    }

    public void setGarminIP(String ip) {
        this.garminIP = ip;
    }

    public void connectToGarmin() throws IOException {
        socket = new Socket(garminIP, garminPort);
    }

    public String receiveData() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        return reader.readLine();
    }

    public void disconnect() throws IOException {
        if (socket != null) {
            socket.close();
        }
    }
}