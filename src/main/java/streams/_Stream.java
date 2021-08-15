package streams;

import static streams._Stream.Gender.*;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _Stream {

	public static void main(String[] args) {
		List<Person> people = List.of(
				new Person("John", MALE),
				new Person("Maria", FEMALE),
				new Person("Beth", FEMALE),
				new Person("Alex", MALE),
				new Person("Alice", FEMALE)
		);

		people.stream()
				.map(person -> person.gender)
				.collect(Collectors.toSet())
				.forEach(System.out::println);


		boolean containsOnlyFemales = people.stream()
				.allMatch(person -> FEMALE.equals(person.gender));

		System.out.println(containsOnlyFemales);
	}

	static class Person {
		private final String name;
		private final Gender gender;

		public Person(String name, Gender gender) {
			this.name = name;
			this.gender = gender;
		}

		@Override
		public String toString() {
			return "Person{" +
					"name='" + name + '\'' +
					", gender=" + gender +
					'}';
		}
	}

	enum Gender {
		MALE, FEMALE
	}
}
