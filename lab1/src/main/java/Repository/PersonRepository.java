package Repository;

import Entity.Person;


/**
 * @author Nikita Vasilyev
 */
public class PersonRepository {
    private static final int INITIAL_SIZE = 1;
    private Person[] people;
    private int lastElem = 0;


    public PersonRepository() {
        people = new Person[INITIAL_SIZE];
    }

    /**
     * Adds a new person to the repository
     * @param p Person Entuty to be added to repository
     */
    public void add(Person p) {
        if (lastElem == people.length) {
            resize();
        }
        people[lastElem++] = p;
    }

    public Person get(int i) {
        return people[i];
    }

    public Person getByID(int id) {
        for (Person p : people) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public int size() {
        return people.length;
    }
    public int elementsCount(){
        return lastElem;
    }


    public void deleteByID(int id){
        boolean found = false;
        int i=-1;
        while (!found && i < people.length){
            i++;
            if (people[i].getId() == id){
                found = true;
            }
        }
        for (int j = i; j <people.length-1; j++){
            people[j] = people[j+1];
        }
        people[people.length-1] = null;
        lastElem--;
    }

    private void resize() {
        Person[] temp = new Person[people.length * 2];
        System.arraycopy(people, 0, temp, 0, people.length);
        people = temp;
    }

}
