package katas.mguzman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BumpsTheRoad {

    public static String bumps(final String road) {


        List<Character> malCamino = new ArrayList<Character>();
        for (int i=0; i<road.length(); i ++){
            malCamino.add(road.charAt(i));
        }
        if (Collections.frequency(malCamino,'n')>=15){
            return "Car Dead";
        }

        return "Woohoo!";
    }
}