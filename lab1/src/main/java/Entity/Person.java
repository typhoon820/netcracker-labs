package Entity;

import Utils.IdGenerator;
import org.joda.time.LocalDate;
import org.joda.time.Years;

public class Person extends AbstractEntity<Integer> {

    private String surname;
    private LocalDate birthDate;

    public Person(String surname, LocalDate birthDate) {
        this.id = IdGenerator.getInstance().getId();
        this.surname = surname;
        this.birthDate = birthDate;
    }



    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.getYear() - birthDate.getYear();
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName()+"{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        if (!surname.equals(person.surname)) return false;
        return birthDate.equals(person.birthDate);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + surname.hashCode();
        result = 31 * result + birthDate.hashCode();
        return result;
    }
}
