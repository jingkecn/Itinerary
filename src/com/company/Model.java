package com.company;

import com.company.tube.Line;
import com.company.tube.Station;
import com.company.utilitaires.TabFileReader;

import java.util.ArrayList;

/**
 * Created by King on 2014-11-30.
 */
public class Model {
    private static ArrayList<Station> stations;
    private static ArrayList<Line> lines;

    public static ArrayList<Station> readStations() {
        String filename = "stations.txt";
        TabFileReader.readTextFile(filename, '\t', "src/data");
        Station station;
        stations = new ArrayList<Station>();
        for (int i = 0; i < TabFileReader.nrow(); i++) {
            station = new Station(
                    TabFileReader.wordAt(i, 0),
                    Integer.parseInt(TabFileReader.wordAt(i, 1)),
                    Integer.parseInt(TabFileReader.wordAt(i, 2))
            );
            stations.add(station);
        }
        return stations;
    }

    public static ArrayList<Line> readLines() {
        String filename = "lines.txt";
        TabFileReader.readTextFile(filename, '\t', "src/data");
        lines = new ArrayList<Line>();
        Line line = null;
        for (int i = 0; i < TabFileReader.nrow(); i++) {
            if (TabFileReader.wordAt(i, 2).equals("0")) {
                if (i != 0) {
                    lines.add(line);
                }
                line = new Line(TabFileReader.wordAt(i, 0));
            } else if (i == TabFileReader.nrow() - 1) {
                lines.add(line);
            }
            line.addStation(TabFileReader.wordAt(i, 1));
            for (Station s : stations) {
                if (s.getName().equals(TabFileReader.wordAt(i, 1))) {
                    s.addLine(TabFileReader.wordAt(i, 0));
                }
            }
        }
        return lines;
    }
}
