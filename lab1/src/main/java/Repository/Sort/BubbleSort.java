package Sort;

import Entity.Person;

public class BubbleSort implements SortStrategy {


    @Override
    public Person[] execute(Person[] unsorted, Comparator<Person> comparator) {
        Person[] sorted = new Person[unsorted.length];
        for (int i = 0; i < unsorted.length; i++) {
            for (int j = unsorted.length - 1; j > i; j--) {
                if(comparator.compare(unsorted[j], unsorted[j-1]) < 0){
                    Person temp = unsorted[j];
                    unsorted[j] = unsorted[j-1];
                    unsorted[j-1] = temp;
                }
            }
        }
        return sorted;
    }
}
