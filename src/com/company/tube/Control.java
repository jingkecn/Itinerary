/*
 * This class finds information about line and itinerary
 * and launches method show() of TubeView to display
 * results.
 */
package com.company.tube;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Control {
    private TubeView tv;
    private Tube tube;
    private String begin, end;

    public Control(Tube tub, TubeView tuv) {
        tube = tub;
        tv = tuv;
        clearItinerary();
    }

    public void clearItinerary() {
        begin = end = null;
    }

    /* -----------------------------------------------------------
     * show the stations belonging to a line.
     * -----------------------------------------------------------
     */
    public void showLine(int pos) {
        System.out.println("USER ACTION: line selection, index= " + pos);
        Line line = tube.lineAt(pos);
        ArrayList<String> selArr = line.getStations();
        String[] sel = new String[selArr.size()];
        for (int i = 0; i < selArr.size(); i++) {
            sel[i] = selArr.get(i);
        }
        tv.show(sel);
    }

    /* -----------------------------------------------------------
     * show a itinerary between two stations.
     * -----------------------------------------------------------
     */
    public void showItinerary(int x, int y) {
        String station;
        station = tube.findClosestStation(x, y).getName();
        System.out.println("USER ACTION: station selection = " + station);
        if (begin == null) {
            begin = station;
            String[] sel = {begin};
            tv.show(sel);
        } else if (end == null) {
            end = station;
            Set<String> selSet = new HashSet<String>(tube.findItinerary(begin, end));
            //System.out.println(selSet);
            String[] sel = selSet.toArray(new String[selSet.size()]);
            if (selSet.isEmpty()) {
                JOptionPane.showMessageDialog(tv, "No direct path has been found.");
                System.out.println("No direct path has been found.");
                sel = null;
                begin = null;
                end = null;
            }
            tv.show(sel);
        }
    }
}
