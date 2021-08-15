package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

	public static void main(String[] args) {
		// Function: takes 1 arguments and produces 1 result
		int increment = incrementByOne(1);
		System.out.println(increment);

		int increment2 = incrementByOneFunction.apply(1);
		System.out.println(increment2);

		int multiply = multiplyBy10Function.apply(increment2);
		System.out.println(multiply);

		int chaining = addBy1AndThenMultiplyBy10.apply(2);
		System.out.println(chaining);

		// BiFunction: takes 2 arguments and produces 1 result
		System.out.println(
				incrementByOneAndMultiply(4, 100)
		);

		System.out.println(
				incrementByOneAndMultiplyBiFunction.apply(4, 100)
		);
	}

	static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

	static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

	static Function<Integer, Integer> addBy1AndThenMultiplyBy10 = incrementByOneFunction.andThen(multiplyBy10Function);

	static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
			(numberToIncrementByOne, numberToMultiplyBy)
					-> (numberToIncrementByOne + 1) * numberToMultiplyBy;

	static int incrementByOne(int number) {
		return number + 1;
	}

	static int incrementByOneAndMultiply(int number, int numberToMultiplyBy) {
		return (number + 1) * numberToMultiplyBy;
	}
}
