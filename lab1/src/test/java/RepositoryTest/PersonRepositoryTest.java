package RepositoryTest;

import Entity.Person;
import Repository.PersonRepository;
import org.joda.time.LocalDate;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonRepositoryTest {

    Person p1 = new Person("1a", new LocalDate(2000, 1,1));
    Person p2 = new Person("2b", new LocalDate(2002, 1,1));
    Person p3 = new Person("2a", new LocalDate(2001, 1,1));
    Person p4 = new Person("3a", new LocalDate(2000, 1,1));
    PersonRepository pr = new PersonRepository();
    PersonRepository pr1 = new PersonRepository();

    @Test
    public void ageIsCorrectlyCounted(){
        Person p = new Person("1213", new LocalDate(2000,10,10));
        assertEquals(17,p.getAge());
    }

    @Test
    public void getByAge(){

        pr.add(p1);
        pr.add(p2);
        pr.add(p3);
        pr.add(p4);
        pr1.add(p1);
        pr1.add(p4);
        assertArrayEquals(pr1.getPeople(), pr.getByAge(17).getPeople());
    }

    @Test
    public void sortByAge(){
        pr.add(p1);
        pr.add(p2);
        pr.add(p3);
        pr.sortByAge();
        pr1.add(p2);
        pr1.add(p3);
        pr1.add(p1);
        assertArrayEquals(pr1.getPeople(), pr.getPeople());

    }
    @Test
    public void sortBySurname(){
        pr.add(p1);
        pr.add(p2);
        pr.add(p3);
        pr.sortBySurname();
        pr1.add(p1);
        pr1.add(p3);
        pr1.add(p2);
        assertArrayEquals(pr1.getPeople(), pr.getPeople());

    }

    @Test
    public void getBySurname(){
        pr.add(p1);
        pr.add(p2);
        pr.add(p3);
        pr1.add(p1);
        assertArrayEquals(pr1.getPeople(), pr.getBySurName("1a").getPeople());
    }

    @Test
    public void getByID(){
        pr.add(p1);
        pr.add(p2);
        pr.add(p3);
        assertEquals(p1,pr.getByID(p1.getId()));
        assertEquals(null,pr.getByID(-1));
    }



}