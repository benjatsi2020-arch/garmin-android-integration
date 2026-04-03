// GPSDataHandler.java
// Handle GPS data from Garmin devices

package com.garmin.android;

public class GPSDataHandler {
    private double latitude;
    private double longitude;
    private double altitude;
    private float speed;
    private long timestamp;

    public GPSDataHandler() {
    }

    public void parseGPSData(String data) {
        // Parse data from Garmin device
        // Format: lat,lon,alt,speed,timestamp
        String[] parts = data.split(",");
        if (parts.length >= 5) {
            this.latitude = Double.parseDouble(parts[0]);
            this.longitude = Double.parseDouble(parts[1]);
            this.altitude = Double.parseDouble(parts[2]);
            this.speed = Float.parseFloat(parts[3]);
            this.timestamp = Long.parseLong(parts[4]);
        }
    }

    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public double getAltitude() { return altitude; }
    public float getSpeed() { return speed; }
    public long getTimestamp() { return timestamp; }

    public void setLatitude(double lat) { this.latitude = lat; }
    public void setLongitude(double lon) { this.longitude = lon; }
    public void setAltitude(double alt) { this.altitude = alt; }
    public void setSpeed(float spd) { this.speed = spd; }
    public void setTimestamp(long ts) { this.timestamp = ts; }
}