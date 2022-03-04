package functionalinterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        //Imperative
        System.out.println("Imperative (without Predicate)");
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("0700000000"));
        System.out.println(isPhoneNumberValid("09000000000"));
        //Declarative
        System.out.println("Declarative (with Predicate)");
        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("0700000000"));
        System.out.println(isPhoneNumberValidPredicate.test("09000000000"));

        //And
        System.out.println("Predicate.and");
        System.out.println("isPhoneNumber 06000000000 Valid:"+isPhoneNumberValidPredicate.and(containNumber3).test("06000000000"));
        System.out.println("isPhoneNumber 07000000000 Valid and contains number 3:" + isPhoneNumberValidPredicate.and(containNumber3).test("07000000000"));
        System.out.println("isPhoneNumber 07030000000 Valid and contains number 3:" + isPhoneNumberValidPredicate.and(containNumber3).test("07030000000"));
        System.out.println("isPhoneNumber 07030000000 Valid and contains number 3 and 5:" + isPhoneNumberValidPredicate.and(containNumber3).and(containNumber5).test("07030000000"));
        System.out.println("isPhoneNumber 07030000005 Valid and contains number 3 and 5:" + isPhoneNumberValidPredicate.and(containNumber3).and(containNumber5).test("07030000005"));

        System.out.println("isPhoneNumber 07000000000 Valid OR contains number 3:" + isPhoneNumberValidPredicate.or(containNumber3).test("07000000000"));

        System.out.println("addAndCheckIfEven 2 3:"+addAndCheckIfEven.test(2,3));
        System.out.println("addAndCheckIfEven 3 3:"+addAndCheckIfEven.test(3,3));

    }

    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containNumber3 = phoneNumber -> phoneNumber.contains("3");
    static Predicate<String> containNumber5 = phoneNumber -> phoneNumber.contains("5");

    static BiPredicate<Integer, Integer> addAndCheckIfEven = (a,b) -> (a + b) % 2 == 0;
}
