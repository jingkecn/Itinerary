package com.company.tube;

import com.company.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Tube {

    private ArrayList<Station> stations;
    private ArrayList<Line> lines;
    private Set<String> directItinerary;
    private Set<String> itinerary;

    public Tube() {
        stations = new ArrayList<Station>(Model.readStations());
        lines = new ArrayList<Line>(Model.readLines());
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
            if (distance < minDist) {
                station = s;
                minDist = distance;
            }
        }
        return station;
    }

    /* dummy code */
    public Set<String> findDirectItinerary(String from, String to) {
        directItinerary = new HashSet<String>();
        boolean dir;
        for (Line line : lines) {
            if (line.getStations().contains(from) && line.getStations().contains(to)) {
                dir = (line.getStations().indexOf(from) < line.getStations().indexOf(to));
                directItinerary.addAll(line.getStations().subList(
                        dir ? line.getStations().indexOf(from) : line.getStations().indexOf(to),
                        dir ? line.getStations().indexOf(to) + 1 : line.getStations().indexOf(from) + 1
                ));
            }
        }
        return directItinerary;
    }

    public Set<String> findItinerary(String from, String to) {
        itinerary = new HashSet<String>();
        if (!findDirectItinerary(from, to).isEmpty()) {
            itinerary = findDirectItinerary(from, to);
        } else {
            boolean stop = false;   // Simplify the method of searching itinerary, inspired by Elias
            for (String lName : getStationByName(from).getLines()) {
                for (String sName : getLineByName(lName).getStations()) {
                    if (!findDirectItinerary(sName, to).isEmpty() && !stop) {
                        itinerary.addAll(findDirectItinerary(from, sName));
                        itinerary.addAll(findDirectItinerary(sName, to));
                        stop = true;
                    }
                }
            }
        }
        return itinerary;
    }

    private Station getStationByName(String name) {
        Station station = null;
        for (Station s : stations) {
            if (s.getName().equalsIgnoreCase(name)) {
                station = s;
            }
        }
        return station;
    }

    private Line getLineByName(String name) {
        Line line = null;
        for (Line l : lines) {
            if (l.getName().equalsIgnoreCase(name)) {
                line = l;
            }
        }
        return line;
    }

    public Line lineAt(int pos) {
        return lines.get(pos);
    }
}
