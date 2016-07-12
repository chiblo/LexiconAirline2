package Domain;

import java.util.List;

public class Company {
    private List<Plane> airPlanes;
    public Company(int numberOfPlanes){
        for (int i = 0; i < numberOfPlanes; i++ ){
            airPlanes.add(new Plane("PLN"+i));
        }
    }
}
