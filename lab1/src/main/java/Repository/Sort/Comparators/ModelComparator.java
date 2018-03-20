package Repository.Sort.Comparators;

import Entity.Car;

import java.util.Comparator;

public class ModelComparator implements Comparator<Car> {
    @Override
    public int compare(Car a, Car b) {
        if (a == null && b == null) {
            return 0;
        }
        if (a == null) {
            return 1;
        }
        if (b == null) {
            return -1;
        }
        return a.getModel().compareTo(b.getModel());
    }
}
