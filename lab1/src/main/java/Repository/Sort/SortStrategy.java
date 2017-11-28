package Repository.Sort;

import Entity.Person;

import java.util.Comparator;

public interface SortStrategy<T> {
    void execute(Person[] unsorted, Comparator<T> comparator);
}
