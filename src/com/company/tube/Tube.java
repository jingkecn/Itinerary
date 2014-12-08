package com.company.tube;

import com.company.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Tube {

    private ArrayList<Station> stations;
    private ArrayList<Line> lines;
    //private String[] directItinerary;
    private Set<String> directItinerary;
    //private int cntLines;

    public Tube() {
        stations = new ArrayList<Station>(Model.readStations());
        lines = new ArrayList<Line>(Model.readLines());
        //directItinerary = new String[10];
        //directItinerary = new HashSet<String>();
        //cntLines = 0;
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
        int minDist = Integer.MAX_VALUE;
        int distance;
        Station station = null;
        for (Station s : stations) {
            distance = ((x - s.getX()) * (x - s.getX()) + (y - s.getY()) * (y - s.getY()));
            if (distance < minDist){
                station = s;
                minDist = distance;
            }
        }
        return station;
    }

    /* dummy code */
    public Set<String> findDirectItinerary(String from, String to) {
        directItinerary = new HashSet<String>();
        for (Line line : lines) {
            if (line.getStations().contains(from) && line.getStations().contains(to)) {
                for (int i = line.getStations().indexOf(from); i <= line.getStations().indexOf(to); i++) {
                    directItinerary.add(line.getStations().get(i));
                }
            }
        }
        return directItinerary;
    }

    public Line lineAt(int pos) {
        return lines.get(pos);
    }
}
