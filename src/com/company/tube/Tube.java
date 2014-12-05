package com.company.tube;

import com.company.Model;

import java.util.ArrayList;

public class Tube {

    private ArrayList<Station> stations;
    private ArrayList<Line> lines;
    private String[] directItinerary;
    private int cnt;

    public Tube() {
        stations = new ArrayList<Station>(Model.readStations());
        lines = new ArrayList<Line>(Model.readLines());
        directItinerary = new String[10];
        cnt = 0;
    }


    /* dummy code */
    public int numberOfStations() {
        return stations.size();
    }

    /* dummy code */
    public Station stationAt(int i) {
        return stations.get(i);
    }

    /* dummy code */
    public Station findClosestStation(int x, int y) {
        double minDistInv = 0;
        double distance;
        Station station = null;
        for (Station s : stations) {
            distance = (double) ((x - s.getX()) ^ 2 + (y - s.getY()) ^ 2);
            if (distance != 0.0 && 1.0 / distance > minDistInv) {
                minDistInv = 1.0 / distance;
                station = s;
            }
        }
        return station;
    }

    /* dummy code */
    public String[] findDirectItinerary(String from, String to) {
        for (Line line : lines) {
            if (line.getStations().contains(from) && line.getStations().contains(to)) {
                directItinerary[cnt++] = line.getName();
            }
        }
        return directItinerary;
    }

    public Line lineAt(int pos) {
        return lines.get(pos);
    }
}
