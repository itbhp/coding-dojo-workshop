package dojo.software.crafters;

import java.util.List;

public class FizzBuzz {

    interface Rule {
        String adapt(int number);

        static Rule combine(Rule first, Rule second){
            return number -> {
                var r1 = first.adapt(number);
                var r2 = second.adapt(number);
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
        public String adapt(int number) {
            if (number % divisor == 0) {
                return motto;
            }
            return "";
        }
    }

    public static String fizzBuzz(int number) {
        var rules = List.of(new NumberRule("Fizz", 3), new NumberRule("Buzz", 5));
        var combinedRule = rules.stream().reduce(Rule.identity, Rule::combine, (rule, rule2) -> {
            throw new UnsupportedOperationException();
        });
        var result = combinedRule.adapt(number);
        return result.equals("") ? String.valueOf(number) : result;
    }
}
