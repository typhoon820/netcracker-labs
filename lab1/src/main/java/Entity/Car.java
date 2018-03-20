package Entity;

import Utils.IdGenerator;
import org.joda.time.LocalDate;

public class Car extends AbstractEntity<Integer>{

    private String model;
    private int horsePower;

    public Car(String model, int horsePower) {
        this.id = IdGenerator.getInstance().getId();
        this.model = model;
        this.horsePower = horsePower;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (horsePower != car.horsePower) return false;
        return model.equals(car.model);
    }

    @Override
    public int hashCode() {
        int result = model.hashCode();
        result = 31 * result + horsePower;
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", horsePower=" + horsePower +
                ", id=" + id +
                '}';
    }
}
