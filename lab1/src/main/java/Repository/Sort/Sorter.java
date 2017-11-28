package Repository.Sort;

import Entity.Person;

import java.util.Comparator;

public class Sorter<T> {

    private SortStrategy<T> sortStrategy;

    public void setSortStrategy(SortStrategy<T> sortStrategy){
        this.sortStrategy = sortStrategy;
    }

    public void execute(Person[] unsorted, Comparator<T> comparator){
        sortStrategy.execute(unsorted, comparator);
    }
}
