package Sort;

import Entity.Person;

public class Sorter<T> {

    private SortStrategy sortStrategy;

    public void setSortStrategy(SortStrategy sortStrategy){
        this.sortStrategy = sortStrategy;
    }

    public Person[] execute(Person[] unsorted, Comparator<T> comparator){
        return sortStrategy.execute(unsorted, comparator);
    }
}
