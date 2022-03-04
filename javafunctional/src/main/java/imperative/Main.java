package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static imperative.Main.Gender.*;

public class Main {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE)
                );

        // Imperative approach
        List<Person> females = new ArrayList<>();

        for (Person person : people){
            if (person.gender.equals(FEMALE)) {
                females.add(person);
            }
        }
        for (Person female : females) System.out.println(female);

        // Declarative approach
        females = people.stream().filter((p) -> p.gender.equals(FEMALE)).collect(Collectors.toList());
        females.forEach(System.out::println);

    }

    static class Person{
        private String name;
        private Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }
    enum Gender {
        MALE, FEMALE
    }
}
