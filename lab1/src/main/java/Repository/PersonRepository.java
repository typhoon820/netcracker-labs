package Repository;

import Config.Configurator;
import Entity.Person;
import Repository.Search.PersonPredicates;
import Repository.Sort.*;
import Repository.Sort.Comparators.AgeComparator;
import Repository.Sort.Comparators.IdComparator;
import Repository.Sort.Comparators.SurnameComparator;
import org.apache.log4j.Logger;


/**
 * @author Nikita Vasilyev
 */
public class PersonRepository extends AbstractRepository<Person, Integer> {

    private static final Logger log = Logger.getLogger(PersonRepository.class);

    /**
     * @param id ID of person to be found
     * @return person with certain ID
     */
    public Person getByID(int id) {
        log.info("Started searching person with ID = " + id);
        for (Object p : entities) {
            if (p != null && PersonPredicates.hasId(id).test((Person) p)) {
                log.info("Person with id = " + id + " was found");
                return (Person) p;

            }
        }
        log.warn("No person with ID = " + id + " found");
        return null;
    }

    /**
     * @param age int key of person to be found
     * @return array pf people of certain age
     */
    public PersonRepository getByAge(int age) {
        log.info("Started searching person of age = " + age);
        PersonRepository result = new PersonRepository();
        for (int i = 0; i < getLastElem(); ++i) {
            if (PersonPredicates.isOfAgeOf(age).test((Person) entities[i])) {
                result.add((Person) entities[i]);
            }
        }
        log.info("Found " + result + " people of age " + age);
        return result;
    }


    /**
     * @param surName String key of person to be found
     * @return array of people with certain surname
     */
    public PersonRepository getBySurName(String surName) {
        PersonRepository result = new PersonRepository();
        for (int i = 0; i < getLastElem(); ++i) {
            if (PersonPredicates.hasName(surName).test((Person) entities[i])) {
                result.add((Person) entities[i]);
            }
        }
        return result;
    }


    /**
     * Sorts people array by surname, Sort strategy by default is equal to property file
     */
    public void sortBySurname() {
        sort(new SurnameComparator());
    }

    /**
     * Sorts people array by surname
     *
     * @param strategy sorting algorithm
     */
    public void sortBySurname(SortStrategy<Person> strategy) {
        try {
            sorter.setSortStrategy(strategy);
            strategy.execute(entities, new SurnameComparator());
        } catch (NullPointerException e) {
            log.error(e);
        }
    }

    /**
     * Sorts people array by Age, Sort strategy by default is equal to property file
     */
    public void sortByAge() {
        sort(new AgeComparator());
    }


    /**
     * Sorts people array by age
     *
     * @param strategy sorting algorithm
     */
    public void sortByAge(SortStrategy<Person> strategy) {
        try {
            sorter.setSortStrategy(strategy);
            sorter.execute(entities, new AgeComparator());
        }
        catch (NullPointerException e){
            log.error(e);
        }
    }

    /**
     * Sorts people array by ID, Sort strategy by default is equal to property file
     */
    public void sortById() {
        sort(new IdComparator());
    }

    /**
     * Sorts people array by ID
     *
     * @param strategy sorting algorithm
     */
    public void sortById(SortStrategy<Person> strategy) {
        try {
            sorter.setSortStrategy(strategy);
            sorter.execute(entities, new IdComparator());
        }
        catch (NullPointerException e){
            log.error(e);
        }
    }

}
