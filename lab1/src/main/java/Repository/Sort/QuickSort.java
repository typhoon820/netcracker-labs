package Repository.Sort;

import Entity.Person;

import java.util.Comparator;
import java.util.Random;

public class QuickSort implements SortStrategy<Person> {
    private static final Random RNG = new Random();

    @Override
    public void execute(Person[] unsorted, Comparator<Person> comparator) {
        quickSort(unsorted, 0, unsorted.length - 1, comparator);
    }

    private void quickSort(Person[] array, int start, int end, Comparator<Person> comparator) {
        if (start < end) {
            int index = partition(array, start, end, comparator);
            quickSort(array, start, index - 1, comparator);
            quickSort(array, index + 1, end, comparator);
        }

    }

    private int partition(Person[] array, int start, int end, Comparator<Person> comparator) {
        int index = start + RNG.nextInt(end - start + 1);
        Person pivot = array[index];
        swap(array, index, end);
        for (int i = index = start; i < end; ++i) {
            if (comparator.compare(array[i], pivot) <= 0) {
                swap(array, index++, i);
            }
        }
        swap(array, index, end);
        return index;
    }

    private void swap(Person[] array, int i, int j) {
        Person temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
