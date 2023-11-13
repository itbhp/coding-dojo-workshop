package dojo.software.crafters;

import java.util.List;

public class FizzBuzz {
    private static final NumberRule fizzRule = new NumberRule(3, "Fizz");
    private static final NumberRule buzzRule = new NumberRule(5, "Buzz");
    private static final List<Rule> rules = List.of(fizzRule, buzzRule);
    private static final Rule identityRule = (n) -> "";
    private static final Rule combinedRule = rules.stream().reduce(identityRule, FizzBuzz::combine);

    public static String fizzBuzz(int number) {
        String result = combinedRule.applyTo(number);
        return result.isBlank() ? String.valueOf(number) : result;
    }

    private interface Rule {
        String applyTo(int number);
    }

    private record NumberRule(int testNumber, String motto) implements Rule {
        @Override
        public String applyTo(int number) {
            return number % testNumber == 0 ? motto : "";
        }
    }

    private static Rule combine(Rule a, Rule b) {
        return number -> {
            var resultA = a.applyTo(number);
            var resultB = b.applyTo(number);
            return resultA + resultB;
        };
    }
}
