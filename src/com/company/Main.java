package com.company;

import com.company.tube.Tube;
import com.company.tube.TubeView;

public class Main {

    public static void main(String[] args) {
        // write your code here
        TubeView tv = new TubeView(new Tube());
        tv.show(null);
    }
}
