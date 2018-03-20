import Entity.Car;
import Entity.Person;
import Repository.CarRepository;
import Repository.PersonRepository;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.LocalDate;
import org.joda.time.Seconds;

public class Main {
    public static void main(String[] args) {

        LocalDate ld = LocalDate.now();

        LocalDate l = new LocalDate(2016,10,13);

        Person n = new Person("Zikita", new LocalDate(1996,3,22));

        Person p2 = new Person("Petya", new LocalDate(2003,3,22));

        Person p3 = new Person( "Vasya", new LocalDate(1994,3,22));
        PersonRepository repository = new PersonRepository();
        repository.add(n);
        repository.add(p2);
        repository.add(p3);
        repository.getByAge(21);
        repository.sortByAge();
        repository.sortById();
        repository.sortBySurname();
        System.out.println(repository.getByAge(21));
        Car c = new Car("dd",11);
        CarRepository cr = new CarRepository();


        int[] ar = {1,2,3,4};
        System.out.println(ar);

    }
}
