import Entity.Person;
import Repository.PersonRepository;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.LocalDate;
import org.joda.time.Seconds;

public class Main {
    public static void main(String[] args) {

        LocalDate ld = LocalDate.now();

        LocalDate l = new LocalDate(2016,10,13);

        Person n = new Person(1, "Nikita", new LocalDate(1996,3,22));

        Person p2 = new Person(3, "Petya", new LocalDate(1996,3,22));

        Person p3 = new Person(2, "Vasya", new LocalDate(1996,3,22));
        PersonRepository repository = new PersonRepository();
        repository.add(n);
        repository.add(p2);
        repository.add(p3);
        repository.deleteByID(4);
        System.out.println(repository.elementsCount());
    }
}
