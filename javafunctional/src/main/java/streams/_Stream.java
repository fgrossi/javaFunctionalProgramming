package streams;

import imperative.Main;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static streams._Stream.Gender.FEMALE;
import static streams._Stream.Gender.MALE;

public class _Stream {

    public static void main(String[] args) {

               List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE)
                );

        System.out.println("*****************");
        people.stream().map(p -> p.gender).collect(Collectors.toSet()).forEach(System.out::println);
        System.out.println("*****************");
        people.stream().map(p -> p.gender).collect(Collectors.toList() ).forEach(System.out::println);
        System.out.println("*****************");

//
//
//        System.out.println(people.stream().mapToInt(person -> person.name.length()));
//





        boolean containsOnlyFemale = people.stream().allMatch(person -> FEMALE.equals(person.gender));
        System.out.println("containsOnlyFemale="+containsOnlyFemale);

        boolean containsAnyFemale = people.stream().anyMatch(person -> FEMALE.equals(person.gender));
        System.out.println("containsAnyFemale="+containsAnyFemale);
    }

    static class Person{
        private final String name;
        private final Gender gender;

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
