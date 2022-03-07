package functionalinterface;


import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.OptionalDouble;

import static functionalinterface.Main.GENDER.FEMALE;
import static functionalinterface.Main.GENDER.MALE;

public class Main {
    /*
    my exercise
     */
    static enum GENDER {
        MALE, FEMALE
    }

    static class Person {
        private final String name;
        private final String email;
        private final LocalDate dob;


        private final GENDER gender;

        public Person(String name, String email, LocalDate dob, GENDER gender) {
            this.name = name;
            this.email = email;
            this.dob = dob;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public LocalDate getDob() {
            return dob;
        }

        public GENDER getGender() {
            return gender;
        }

        public int getAge() {
            return Period.between(dob, LocalDate.now()).getYears();
        }
    }

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Maria", "maria@gmail.com", LocalDate.of(1953, 7, 31), FEMALE),
                new Person("Francesco", "francesco@gmail.com", LocalDate.of(1963, 7, 31), MALE),
                new Person("Igor", "igor@gmail.com", LocalDate.of(1973, 7, 31), MALE),
                new Person("Yury", "yury@gmail.com", LocalDate.of(1983, 7, 31), MALE),
                new Person("Silvia", "silvia@gmail.com", LocalDate.of(1993, 7, 31), FEMALE),
                new Person("Gina", "gina@gmail.com", LocalDate.of(2003, 7, 31), FEMALE)
        );


        System.out.println(people.stream().filter(
                p -> p.getGender().equals(MALE))
                .mapToInt(p -> p.getAge())
                .average().getAsDouble());

    }
}
