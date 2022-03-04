package functionalinterface;

/*
https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
 */
import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {

        // Function takes 1 argument and produces 1 result
        int increment = incrementByOne(0);
        System.out.println(increment);

        int increment2 = incrementByOneFunction.apply(0);
        System.out.println(increment2);

        /*
        andThen
         */
        // creo una seconda Function
        int multiply = multiplyBy10Function.apply(increment2);
        System.out.println(multiply);

        // concateno le 2 functions

        Function<Integer, Integer> addBy1AndThenMultiplyBy10 = incrementByOneFunction.andThen(multiplyBy10Function);
        multiply = addBy1AndThenMultiplyBy10.apply(9);
        System.out.println(multiply);

        // BiFunction takes 2 argument and produces 1 result

        System.out.println(
                incrementByOneAndMultiply(4,100)
        );

        System.out.println(
                incrementByOneAndMultiplyBiFunction.apply(4,100)
        );

//        int bifuncresult = incrementByOneAndMultiplyBiFunction.apply(10,5);
//        System.out.println(bifuncresult);

    }

    //Function: takes 1 input and returns output

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

    static int incrementByOne(int number){
        return number + 1;
    }

    //Bifunction: takes 2 input and returns output

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy)
                    -> (numberToIncrementByOne + 1) * numberToMultiplyBy;

    static int incrementByOneAndMultiply(int number,int numToMultiplyBy){
        return (number + 1) * numToMultiplyBy;
    }

}
