package finalsection;

import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        hello("John", null, (value -> System.out.println("no lastName provided for " + value)));
        hello2("John", null, () -> System.out.println("no lastName provided"));

    }

    /*
    implementing callback with functional programming interface (in this particular case: Consumer)
     */
    static void hello(String firstName, String lastName, Consumer<String> myfunc) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            myfunc.accept("no lastName provided for " + firstName);
        }
    }

    /*
    implementing callback with Runnable interface
     */
    static void hello2(String firstName, String lastName, Runnable myfunc) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            myfunc.run();
        }
    }
}
