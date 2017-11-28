package Repository.Sort;

import Entity.Person;

import java.util.Comparator;

public class InsertionSort implements SortStrategy<Person> {

    @Override
    public void execute(Person[] unsorted, Comparator<Person> comparator) {
        for (int i =0; i < unsorted.length; ++i){
            Person key = unsorted[i];
            int j = i-1;
            while( j>= 0 && comparator.compare(unsorted[j], key)>0){
                unsorted[j+1] = unsorted[j];
                j = j-1;
            }
            unsorted[j+1] = key;
        }
    }
}
