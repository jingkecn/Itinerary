package com.company.tube;

import java.util.ArrayList;

public class Line {
    private String name;
    private ArrayList<String> stations;

    //private int nbOfStation;
    public Line(String name) {
        this.name = name;
        this.stations = new ArrayList<String>();
        //this.nbOfStation = 0;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getStations() {
        return stations;
    }

	/*
     * Writes the code corresponding to the following example:
	 * */
    /*public static void main(String[] args) {
		Line line = new Line("Jubilee_line");
		line.addStation("Baker Street");
		line.addStation("Bond Street");
		line.addStation("Green Park");
		line.addStation("Westminster");
		line.addStation("Waterloo");
		System.out.println("line= " + line.getName());
		for (int i = 0; i < line.numberOfStations(); i++) {
			System.out.println("station =" + line.stationAt(i).getName());
		}
	}*/

    private String stationAt(int index) {
        return stations.get(index);
    }

    private int numberOfStations() {
        return stations.size();
    }

    public void addStation(String station) {
        if (!stations.contains(station)) {
            stations.add(station);
        }
		/*for (Station station : stations){
			if (station.getName().equalsIgnoreCase(name)){
				stations.add(station);
			}
		}*/
    }
}
