package supercoders.parking.model.containers;
import java.util.*;

import supercoders.parking.model.ParkingSpot;
/**
 * Write a description of class ParkingSpaceContainer here.
 *
 * @author GiBe
 * @version October 2020
 */
public class ParkingSpaceContainer
{
    private static ParkingSpaceContainer uniqueInstance = new ParkingSpaceContainer();

    private ArrayList<ParkingSpot> parkingPlaces = new ArrayList<>();

    private ParkingSpaceContainer() {
    }

    public static ParkingSpaceContainer getInstance() {
        return uniqueInstance;
    }

    public boolean addParkingSpace (ParkingSpot p) {
        boolean result = false;
        if (p!= null) {
            result = parkingPlaces.add(p);
        }
        return result;
    }

    public ParkingSpot findFirstAvailableParkingPlace(){
        ParkingSpot freeParkingPlace = null;
        boolean searching = true;
        Iterator<ParkingSpot> it = parkingPlaces.iterator();
        while (it.hasNext() && searching){
            ParkingSpot p = it.next();
            if (p.isAvailable()){
                freeParkingPlace = p;
                searching = false;
                //do we need to put available to false? no, only when we assign it
            }
        }
        return freeParkingPlace;
    }
}
