package Repository;

import Entity.Car;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarRepositoryTest extends AbstractRepository {
    CarRepository carRepository1 = new CarRepository();
    CarRepository carRepository = new CarRepository();



    @Test
    public void sortByHorsepower() throws Exception {
    }

    @Test
    public void sortByModel() throws Exception {
    }

    @Test
    public void sortByModel1() throws Exception {
    }

    @Test
    public void sortByHorepower() throws Exception {
    }

    @Test
    public void getByHorsePower() throws Exception {
        Car c1= new Car("BMW", 200);
        Car c2= new Car("LADA", 77);
        Car c3= new Car("SAAB", 120);

        carRepository1.add(c2);
        carRepository.add(c1);
        carRepository.add(c2);
        carRepository.add(c3);
        Car[] cars = new Car[5];
        Car[] cars1 = new Car[5];
        assertArrayEquals(carRepository1.getAll(cars1), carRepository.getByHorsePower(77).getAll(cars));
    }

    @Test
    public void getByModel() throws Exception {
        Car c1= new Car("BMW", 200);
        Car c2= new Car("LADA", 77);
        Car c3= new Car("SAAB", 120);

        carRepository1.add(c3);
        carRepository.add(c1);
        carRepository.add(c2);
        carRepository.add(c3);
        Car[] cars = new Car[5];
        Car[] cars1 = new Car[5];
        assertArrayEquals(carRepository1.getAll(cars1), carRepository.getByModel("SAAB").getAll(cars));
    }

}