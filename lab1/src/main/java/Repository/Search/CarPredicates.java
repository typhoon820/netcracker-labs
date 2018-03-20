package Repository.Search;

import Entity.Car;
import Entity.Person;

import java.util.function.Predicate;

public class CarPredicates {
    public static Predicate<Car> modelIs(String name){
        return car -> car.getModel().equals(name);
    }

    public static Predicate<Car> horsepowerIs(int hp){
        return car -> car.getHorsePower() == hp;
    }

    public static Predicate<Car> hasId(int id){
        return car -> car.getId() == id;
    }
}
