package dojo.software.crafters;

import java.util.List;

public class FizzBuzz {

    /*
        Code smells:

        1. Duplications: mapping value Fizz and Buzz are repeated
        2. Somehow also the divisible logic is repeated
        3. Temporal coupling: if we change the order of the ifs the code will not work
     */

    record Rule(String motto, int divisor) {
        boolean isSatisfiedBy(int number) {
            return number % divisor == 0;
        }
    }

    public static String fizzBuzz(int number) {
        // refactoring removing mutability
        var rules = List.of(new Rule("Fizz", 3), new Rule("Buzz", 5));

        String result = rules.stream().map(rule -> {
            if (rule.isSatisfiedBy(number)) {
                return rule.motto;
            } else {
                return "";
            }
        }).reduce("", String::concat);

        return result.isEmpty() ? String.valueOf(number) : result;
    }
}
