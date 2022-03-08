package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.*;

public class Main {

    public static void main(String[] args) {
        Customer customer;
        customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "05454545",
                LocalDate.of(2000, 7, 17)
        );
//        System.out.println(new CustomerValidatorService().isValid(customer));

        // Using combinator pattern
        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult()).apply(customer);

        System.out.println(result);
        if (result != ValidationResult.SUCCESS) throw new IllegalStateException(String.valueOf(result));



    }
}
