package supercoders.parking.model;
import java.util.*;
/**
 * Write a description of class ParkingSpaceContainer here.
 *
 * @author GiBe
 * @version October 2020
 */
public class ParkingSpaceContainer
{
    private static ParkingSpaceContainer uniqueInstance = new ParkingSpaceContainer();

    private ArrayList<ParkingSpace> parkingPlaces = new ArrayList<>();

    private ParkingSpaceContainer() {
    }

    public static ParkingSpaceContainer getInstance() {
        return uniqueInstance;
    }

    public boolean addParkingSpace (ParkingSpace p) {
        boolean result = false;
        if (p!= null) {
            result = parkingPlaces.add(p);
        }
        return result;
    }

    public ParkingSpace findFirstAvailableParkingPlace(){
        ParkingSpace freeParkingPlace = null;
        boolean searching = true;
        Iterator<ParkingSpace> it = parkingPlaces.iterator();
        while (it.hasNext() && searching){
            ParkingSpace p = it.next();
            if (p.isAvailable()){
                freeParkingPlace = p;
                searching = false;
                //do we need to put available to false? no, only when we assign it
            }
        }
        return freeParkingPlace;
    }
}
