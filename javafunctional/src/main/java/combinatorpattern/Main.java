package combinatorpattern;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Customer customer;
        customer = new Customer(
                "Alice", "alice@gmail.com", "+05454545", LocalDate.of(2000, 7,17)
        );
        System.out.println(new CustomerValidatorService().isValid(customer));
    }
}
