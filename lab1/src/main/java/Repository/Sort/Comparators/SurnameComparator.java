package Repository.Sort.Comparators;

import Entity.Person;

import java.util.Comparator;

public class SurnameComparator implements Comparator<Person> {
    @Override
    public int compare(Person a, Person b) {
        if(a == null && b == null){
            return 0;
        }
        if(a == null){
            return 1;
        }
        if(b == null){
            return -1;
        }
        return a.getSurname().compareTo(b.getSurname());
    }
}
