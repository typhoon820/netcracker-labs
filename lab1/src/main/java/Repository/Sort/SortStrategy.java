package Sort;

import Entity.Person;

public interface SortStrategy {
    Person[] execute(Person[] unsorted, Comparator<Person> comparator);
}
