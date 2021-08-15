package functionalinterface;

import java.util.function.Predicate;

public class _Predicate {

	public static void main(String[] args) {

		System.out.println(isPhoneNumberValid("0010010000"));
		System.out.println(isPhoneNumberValid("000010000"));
		System.out.println(isPhoneNumberValid("0110010000"));

		System.out.println(isPhoneNumberValidPredicate.test("0010010000"));
		System.out.println(isPhoneNumberValidPredicate.test("000010000"));
		System.out.println(isPhoneNumberValidPredicate.test("0110010000"));

		System.out.println(
				"Is phone number valid AND contains number 3 = " +
				isPhoneNumberValidPredicate.and(containsNumber3).test("0010010000")
		);

		System.out.println(
				"Is phone number valid OR contains number 3 = " +
						isPhoneNumberValidPredicate.or(containsNumber3).test("000030000")
		);

	}

	static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
			phoneNumber.startsWith("00") && phoneNumber.length() == 10;

	static Predicate<String> containsNumber3 = phoneNumber ->
			phoneNumber.contains("3");

	static boolean isPhoneNumberValid(String phoneNumber) {
		return phoneNumber.startsWith("00") && phoneNumber.length() == 10;
	}

}
