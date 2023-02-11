package dojo.software.crafters;

import java.util.List;

public class FizzBuzz {

    interface Rule {
        String applyTo(int number);

        static Rule combine(Rule first, Rule second) {
            return number -> {
                var r1 = first.applyTo(number);
                var r2 = second.applyTo(number);
                return r1 + r2;
            };
        }

        Rule identity = number -> "";
    }

    static class NumberRule implements Rule {
        private final String motto;
        private final int divisor;

        public NumberRule(String motto, int divisor) {
            this.motto = motto;
            this.divisor = divisor;
        }

        @Override
        public String applyTo(int number) {
            if (number % divisor == 0) {
                return motto;
            }
            return "";
        }
    }

    private static final List<Rule> rules =
            List.of(new NumberRule("Fizz", 3), new NumberRule("Buzz", 5));

    private static final Rule combinedRule = rules.stream().reduce(Rule.identity, Rule::combine);

    public static String fizzBuzz(int number) {
        var result = combinedRule.applyTo(number);
        return result.isEmpty() ? String.valueOf(number) : result;
    }
}
