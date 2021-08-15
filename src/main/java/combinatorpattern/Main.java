package combinatorpattern;

import static combinatorpattern.CustomerRegistrationValidator.*;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		var customer = new Customer(
				"Alice",
				"alice@gmail.com",
				"+02319283190248",
				LocalDate.of(2000, 1, 1)
		);


		// System.out.println(new CustomerValidatorService().isValid(customer));

		// if valid we can store customer in db

		// Using combinator pattern
		ValidationResult result = isEmailValid()
				.and(isPhoneNumberValid())
				.and(isAdult())
				.apply(customer);

		System.out.println(result);

		if (result != ValidationResult.SUCCESS) {
			throw new IllegalStateException(result.name());
		}

	}
}
