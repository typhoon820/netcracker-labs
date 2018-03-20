package Repository.Search;

import Entity.Person;

import java.util.function.Predicate;

public class PersonPredicates{

    public static Predicate<Person> hasName(String name){
        return person -> person.getSurname().equals(name);
    }

    public static Predicate<Person> isOfAgeOf(int age){
        return person -> person.getAge() == age;
    }

    public static Predicate<Person> hasId(int id){
        return person -> person.getId() == id;
    }
}
