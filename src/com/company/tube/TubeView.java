package com.company.tube;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("serial")
public class TubeView extends JFrame implements MouseListener {
    private Image image;
    private Tube tube;
    private Control control;
    private boolean[] selected;
    private int[] xlines = {880, 880, 880, 880, 994, 994, 994, 994};
    private int[] ylines = {56, 86, 112, 140, 56, 86, 112, 140};

    public TubeView(Tube t) {
        tube = t;
        control = new Control(t, this);
        String fileimage = "src/data/londonTube.jpg";
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(" LONDON TUBE MAP");
        this.setSize(1100, 570);
        ImageIcon icon = new ImageIcon(fileimage);
        image = icon.getImage();
        addMouseListener(this);
    }

    /* -----------------------------------------------------------
     * the main shows an empty map
     * -----------------------------------------------------------
     */
    public static void main(String[] args) {
        TubeView tv = new TubeView(new Tube());
        tv.show(null);
    }

    public void init(String[] selection) {
        int nbStations = tube.numberOfStations();
        selected = new boolean[tube.numberOfStations()];
        if (selection != null) {
            for (int i = 0; i < nbStations; i++) {
                String stationName = tube.stationAt(i).getName();
                boolean found = false;
                for (int j = 0; j < selection.length && !found; j++)
                    if (selection[j] != null) {
                        if (selection[j].equals(stationName)) found = true;
                    }
                if (found) selected[i] = true;
            }
        }
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        // clear : show an empty map
        if ((x >= 31) && (x <= 146) && (y >= 117) && (y <= 214)) clear();
            // show line stations
        else if ((x >= 812) && (x <= 1054) && (y >= 41) && (y <= 157)) showLine(x, y);
            // last option: itinerary search
        else control.showItinerary(x, y);
        repaint();
    }

    public void paint(Graphics g) {
        g.drawImage(image, 10, 35, this);
        int nbStations = tube.numberOfStations();
        for (int i = 0; i < nbStations; i++)
            if (selected[i]) {
                Station station = tube.stationAt(i);
                int xa = station.getX();
                int ya = station.getY();
                g.setColor(Color.BLACK);
                g.fillOval(xa - 13, ya - 13, 26, 26);
                g.setColor(Color.RED);
                g.fillOval(xa - 11, ya - 11, 22, 22);
                g.setColor(Color.BLACK);
                g.fillOval(xa - 7, ya - 7, 14, 14);
                g.setColor(Color.YELLOW);
                g.fillOval(xa - 4, ya - 4, 8, 8);
            }
    }

    /* -----------------------------------------------------------
     * Show the stations selected in array selection
     * -----------------------------------------------------------
     */
    public void show(String[] selection) {
        init(selection);
        setVisible(true);
    }

    /* -----------------------------------------------------------
     * show the stations belonging to a line.
     * -----------------------------------------------------------
     */
    public void showLine(int x, int y) {
        int pos = -1, mindist = Integer.MAX_VALUE;
        for (int k = 0; k < xlines.length; k++) {
            int dx = x - xlines[k];
            int dy = y - ylines[k];
            int dist2 = dx * dx + dy * dy;
            if (dist2 < mindist) {
                mindist = dist2;
                pos = k;
            }
        }
        control.showLine(pos);
    }

    /* -----------------------------------------------------------
     * clear the map.
     * -----------------------------------------------------------
     */
    public void clear() {
        System.out.println("USER ACTION: clear the map");
        control.clearItinerary();
        show(null);
    }

}
