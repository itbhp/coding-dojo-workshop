package dojo.software.crafters;

import java.util.List;

public class FizzBuzz {

    static Rule combineRules(Rule first, Rule second) {
        return number -> {
            var firstResult = first.applyTo(number);
            var secondResult = second.applyTo(number);
            return firstResult + secondResult;
        };
    }

    interface Rule {
        String applyTo(int number);
    }

    static class NumberRule implements Rule {
        private final String motto;
        private final int divisor;

        NumberRule(String motto, int divisor) {
            this.motto = motto;
            this.divisor = divisor;
        }

        @Override
        public String applyTo(int number) {
            return isSatisfiedBy(number) ? motto : "";
        }

        private boolean isSatisfiedBy(int number) {
            return number % divisor == 0;
        }
    }

    enum IdentityRule implements Rule {
        INSTANCE;

        @Override
        public String applyTo(int number) {
            return "";
        }
    }

    public static String fizzBuzz(int number) {
        List<Rule> rules =
                List.of(new NumberRule("Fizz", 3), new NumberRule("Buzz", 5));

        Rule identityRule = IdentityRule.INSTANCE;
        Rule composedRule = rules.stream()
                .reduce(identityRule, FizzBuzz::combineRules);

        String mapping = composedRule.applyTo(number);
        return mapping.isEmpty() ? String.valueOf(number) : mapping;
    }
}
