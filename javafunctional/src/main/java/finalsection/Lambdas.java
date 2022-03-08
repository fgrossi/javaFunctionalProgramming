package finalsection;

import java.util.Locale;
import java.util.function.Function;

public class Lambdas {
    public static void main(String[] args) {
        Function<String,String> upperCaseName = String::toUpperCase;
        System.out.println(upperCaseName.apply("gino"));
    }
}
