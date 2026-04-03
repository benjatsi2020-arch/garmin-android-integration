// NavigationCommandHandler.java
// Send navigation commands to Garmin

package com.garmin.android;
import java.io.OutputStream;
import java.io.IOException;

public class NavigationCommandHandler {
    private OutputStream outputStream;

    public NavigationCommandHandler(OutputStream out) {
        this.outputStream = out;
    }

    public void sendNavigationCommand(String destination, double lat, double lon) throws IOException {
        String command = "NAV:" + destination + ":" + lat + ":" + lon;
        outputStream.write(command.getBytes());
        outputStream.flush();
    }

    public void sendWaypoint(String waypointName, double lat, double lon) throws IOException {
        String command = "WPT:" + waypointName + ":" + lat + ":" + lon;
        outputStream.write(command.getBytes());
        outputStream.flush();
    }

    public void sendRoute(String routeName, String waypoints) throws IOException {
        String command = "RTE:" + routeName + ":" + waypoints;
        outputStream.write(command.getBytes());
        outputStream.flush();
    }
}