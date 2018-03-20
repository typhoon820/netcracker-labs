package Repository.Sort;

import Entity.Person;

import java.sql.Timestamp;
import java.util.Comparator;

public class BubbleSort<T> implements SortStrategy<T> {

    @Override
    public void execute(Object[] unsorted, Comparator<T> comparator) {
        for (int i = 0; i < unsorted.length; i++) {
            for (int j = unsorted.length - 1; j > i; j--) {
                if(comparator.compare((T)unsorted[j], (T)unsorted[j-1]) < 0){
                    T temp = (T)unsorted[j];
                    unsorted[j] = unsorted[j-1];
                    unsorted[j-1] = temp;
                }
            }
        }
    }
}
