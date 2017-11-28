package Repository.Sort;

import Entity.Person;

import java.util.Comparator;

public class BubbleSort implements SortStrategy<Person> {

    @Override
    public void execute(Person[] unsorted, Comparator<Person> comparator) {
        for (int i = 0; i < unsorted.length; i++) {
            for (int j = unsorted.length - 1; j > i; j--) {
                if(comparator.compare(unsorted[j], unsorted[j-1]) < 0){
                    Person temp = unsorted[j];
                    unsorted[j] = unsorted[j-1];
                    unsorted[j-1] = temp;
                }
            }
        }
    }
}
