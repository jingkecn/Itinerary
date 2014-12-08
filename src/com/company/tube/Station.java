package com.company.tube;

import java.util.HashSet;
import java.util.Set;

public class Station {
    private String name;
    private int x, y;
    //private static Set<Line> lines;
    private Set<String> lines;

    public Station(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.lines = new HashSet<String>() {
        };
    }

    /* dummy code */
    public String getName() {
        return this.name;
    }

    /* dummy code */
    public int getX() {
        return this.x;
    }

    /* dummy code */
    public int getY() {
        return this.y;
    }

	/*
     * Writes the code corresponding to the following example:
	 * 
	 * this main outputs the following message:
	 * station= Baker Street, coord.= (425,126)
	 * line =Bakerloo_line
	 * line =Hammersmith_line
	 * line =Jubilee_lin
	 * */

	/*public static void main(String[] args) {
		Station station=new Station("Baker Street",425,126);
		station.addLine("Bakerloo_line");
		station.addLine("Hammersmith_line");
		station.addLine("Jubilee_line");
		System.out.println(
				"station= " +
				station.getName() +
				", coord.= (" + station.getX() +
				"," +
				station.getY() +
				")"
		);
		for (Line line : lines){
			System.out.println("line = " + line.getName());
		}
		*//*for (int i=0;i<station.numberOfLines();i++){
			System.out.println("line ="+station.lineAt(i).getName());
		}*//*
	}*/

	/*private static Line lineAt(int index) {
		return lines.get(index);
	}*/

    public int numberOfLines() {

        return lines.size();
    }

    public void addLine(String line) {
        lines.add(line);
    }

    public Set<String> getLines() {
        return lines;
    }
}
