package Repository;

import Entity.Person;
import Repository.Search.PersonPredicates;
import Repository.Sort.*;


/**
 * @author Nikita Vasilyev
 */
public class PersonRepository {
    private static final int INITIAL_SIZE = 10;
    private Person[] people;
    private int lastElem = 0;
    private Sorter<Person> sorter = new Sorter<>();


    public PersonRepository() {
        people = new Person[INITIAL_SIZE];
    }

    /**
     * Adds a new person to the repository
     *
     * @param p Person Entity to be added to repository
     */
    public void add(Person p) {
        if (lastElem == people.length) {
            resize();
        }
        people[lastElem++] = p;
    }

    /**
     * @param i index in array of the person to be found
     * @return Person found by index in array
     */
    public Person get(int i) {
        return people[i];
    }

    /**
     * @param id ID of person to be found
     * @return person with certain ID
     */
    public Person getByID(int id) {
        for(Person p: people){
            if(p != null && PersonPredicates.hasId(id).test(p)){
                return p;
            }
        }
        return null;
    }

    /**
     * @param age int key of person to be found
     * @return array pf people of certain age
     */
    public PersonRepository getByAge(int age) {
        PersonRepository result = new PersonRepository();

        for (int i = 0; i < lastElem; ++i) {
            if (PersonPredicates.isOfAgeOf(age).test(people[i])){
                result.add(people[i]);
            }
        }

        return result;
    }


    /**
     * @param surName String key of person to be found
     * @return array of people with certain surname
     */
    public PersonRepository getBySurName(String surName) {
        PersonRepository result = new PersonRepository();
        for (int i = 0; i < lastElem; ++i) {
            if (PersonPredicates.hasName(surName).test(people[i])){
                result.add(people[i]);
            }
        }
        return result;
    }


    /**
     * @return total size of array
     */
    public int size() {
        return people.length;
    }


    /**
     * @return last not-null element of array
     */
    public int elementsCount() {
        return lastElem;
    }


    public void deleteByID(int id) {
        boolean found = false;
        int i = -1;
        while (!found && i < people.length) {
            i++;
            if (people[i] != null && PersonPredicates.hasId(id).test(people[i])) {
                found = true;
            }
        }
        for (int j = i; j < people.length - 1; j++) {
            people[j] = people[j + 1];
        }
        people[people.length - 1] = null;
        lastElem--;
    }


    /**
     * Resizes the people array when there is no more space to add a new one
     */
    private void resize() {
        Person[] temp = new Person[people.length * 2];
        System.arraycopy(people, 0, temp, 0, people.length);
        people = temp;
    }


    /**
     * Sorts people array by surname, Sort strategy by default is BubbleSort
     */
    public void sortBySurname() {
        sorter.setSortStrategy(new BubbleSort());
        sorter.execute(people, new SurnameComparator());
    }

    /**
     * Sorts people array by surname
     * @param strategy sorting algorithm
     */
    public void sortBySurname(SortStrategy<Person> strategy){
        sorter.setSortStrategy(strategy);
        strategy.execute(people, new SurnameComparator());
    }
    /**
     * Sorts people array by Age, Sort strategy by default is BubbleSort
     */
    public void sortByAge() {
        sorter.setSortStrategy(new BubbleSort());
        sorter.execute(people, new AgeComparator());
    }


    /**
     * Sorts people array by age
     * @param strategy sorting algorithm
     */
    public void sortByAge(SortStrategy<Person> strategy){
        sorter.setSortStrategy(strategy);
        sorter.execute(people, new AgeComparator());
    }
    /**
     * Sorts people array by ID, Sort strategy by default is BubbleSort
     */
    public void sortById() {
        sorter.setSortStrategy(new BubbleSort());
        sorter.execute(people, new IdComparator());
    }

    /**
     * Sorts people array by ID
     * @param strategy sorting algorithm
     */
    public void sortById(SortStrategy<Person> strategy){
        sorter.setSortStrategy(strategy);
        sorter.execute(people, new IdComparator());
    }

    public Person[] getPeople() {
        return people;
    }
}
