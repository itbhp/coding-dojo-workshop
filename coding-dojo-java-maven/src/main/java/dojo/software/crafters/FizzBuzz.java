package dojo.software.crafters;

import java.util.List;

public class FizzBuzz {

    /*
        Code smells:

        1. Duplications: mapping value Fizz and Buzz are repeated (-> solved)
        2. Somehow also the divisible logic is repeated  (-> solved)
        3. Temporal coupling: if we change the order of the ifs the code will not work  (-> solved)
     */

    static GameRule combineGameRules(GameRule first, GameRule second) {
        return number -> {
            var firstResult = first.applyTo(number);
            var secondResult = second.applyTo(number);
            return firstResult + secondResult;
        };
    }

    interface GameRule {
        String applyTo(int number);
    }

    static class NumberRule implements GameRule {
        private final String motto;
        private final int divisor;

        NumberRule(String motto, int divisor) {
            this.motto = motto;
            this.divisor = divisor;
        }

        @Override
        public String applyTo(int number) {
            if (isSatisfiedBy(number)) {
                return motto;
            } else {
                return "";
            }
        }

        private boolean isSatisfiedBy(int number) {
            return number % divisor == 0;
        }
    }

    enum IdentityRule implements GameRule {
        INSTANCE;

        @Override
        public String applyTo(int number) {
            return "";
        }
    }

    public static String fizzBuzz(int number) {
        List<GameRule> rules = List.of(new NumberRule("Fizz", 3), new NumberRule("Buzz", 5));

        GameRule identityRule = IdentityRule.INSTANCE;
        GameRule result = rules.stream()
                .reduce(identityRule, FizzBuzz::combineGameRules);

        String rulesResult = result.applyTo(number);
        return rulesResult.isEmpty() ? String.valueOf(number) : rulesResult ;
    }
}
