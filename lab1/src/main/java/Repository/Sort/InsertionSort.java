package Repository.Sort;

import Entity.Person;

import java.util.Comparator;

public class InsertionSort<T> implements SortStrategy<T> {

    @Override
    public void execute(Object[] unsorted, Comparator<T> comparator) {
        for (int i =0; i < unsorted.length; ++i){
            T key = (T)unsorted[i];
            int j = i-1;
            while( j>= 0 && comparator.compare((T)unsorted[j], key)>0){
                unsorted[j+1] = unsorted[j];
                j = j-1;
            }
            unsorted[j+1] = key;
        }
    }
}
