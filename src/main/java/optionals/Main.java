package optionals;

import java.util.Optional;

public class Main {
	public static void main(String[] args) {

		// Default value
		Object value = Optional.ofNullable(null)
				.orElseGet(() -> "default value");

		System.out.println(value);


		// Throw exception
		Optional.ofNullable("john@gmail.com")
				.orElseThrow(() -> new IllegalStateException("exception"));


		// If present
		Optional.ofNullable("john@gmail.com")
				.ifPresent(email -> System.out.println("Sending email to: " + email));


		// If present or Else
		Optional.ofNullable(null)
				.ifPresentOrElse(
						email -> System.out.println("Sending email to: " + email),
						() -> System.out.println("Cannot send email."));

	}
}
