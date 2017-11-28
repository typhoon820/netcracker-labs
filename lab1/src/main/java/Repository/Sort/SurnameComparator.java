package Sort;

import Entity.Person;

public class SurnameComparator implements Comparator<Person> {
    @Override
    public int compare(Person a, Person b) {
        return a.getSurname().compareTo(b.getSurname());
    }
}
