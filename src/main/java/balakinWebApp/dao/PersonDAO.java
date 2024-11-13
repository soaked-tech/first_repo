package balakinWebApp.dao;

import balakinWebApp.models.Person;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;
    private static int PEOPLE_COUNT;
    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom",32,"tom32@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Bob",22,"bobbi22@yandex.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Mike",47,"mike47@mail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Katy",56,"katy56@gmail.com"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {

        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id,Person updatedPerson){
        Person personTiBeUpdated = show(id);

        personTiBeUpdated.setName(updatedPerson.getName());
        personTiBeUpdated.setAge(updatedPerson.getAge());
        personTiBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id){
        people.removeIf(p -> p.getId() == id);


    }
}
