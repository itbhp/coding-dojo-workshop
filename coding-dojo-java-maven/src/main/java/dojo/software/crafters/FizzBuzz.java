package dojo.software.crafters;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;

public class FizzBuzz {

    /*
        Code smells:

        1. Duplications: mapping value Fizz and Buzz are repeated
        2. Somehow also the divisible logic is repeated
        3. Temporal coupling: if we change the order of the ifs the code will not work
     */

    record Rule(String motto, Predicate<Integer> predicate) {
        boolean isSatisfiedBy(int number) {
            return predicate.test(number);
        }
    }

    public static String fizzBuzz(int number) {
        // refactoring using mutability
        AtomicReference<String> result = new AtomicReference<>("");
        Predicate<Integer> fizzTest = n -> n % 3 == 0;
        Predicate<Integer> buzzTest = n -> n % 5 == 0;
        var rules = List.of(new Rule("Fizz", fizzTest), new Rule("Buzz", buzzTest));
        rules.forEach(rule ->
                result.updateAndGet(previous ->
                        rule.isSatisfiedBy(number) ? previous + rule.motto : previous
                )
        );
        return result.get().isEmpty()? String.valueOf(number): result.get();
    }
}
