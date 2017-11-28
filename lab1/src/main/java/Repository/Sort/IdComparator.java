package Sort;

import Entity.Person;

public class IdComparator implements Comparator<Person>{
    @Override
    public int compare(Person a, Person b) {
        return a.getId() - b.getId();
    }
}
