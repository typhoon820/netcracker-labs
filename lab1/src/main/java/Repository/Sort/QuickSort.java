package Repository.Sort;

import Entity.Person;

import java.util.Comparator;
import java.util.Random;

public class QuickSort<T> implements SortStrategy<T> {
    private static final Random RNG = new Random();

    @Override
    public void execute(Object[] unsorted, Comparator<T> comparator) {
        quickSort(unsorted, 0, unsorted.length - 1, comparator);
    }

    private void quickSort(Object[] array, int start, int end, Comparator<T> comparator) {
        if (start < end) {
            int index = partition(array, start, end, comparator);
            quickSort(array, start, index - 1, comparator);
            quickSort(array, index + 1, end, comparator);
        }

    }

    private int partition(Object[] array, int start, int end, Comparator<T> comparator) {
        int index = start + RNG.nextInt(end - start + 1);
        T pivot = (T)array[index];
        swap(array, index, end);
        for (int i = index = start; i < end; ++i) {
            if (comparator.compare((T)array[i], pivot) <= 0) {
                swap(array, index++, i);
            }
        }
        swap(array, index, end);
        return index;
    }

    private void swap(Object[] array, int i, int j) {
        T temp = (T)array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
