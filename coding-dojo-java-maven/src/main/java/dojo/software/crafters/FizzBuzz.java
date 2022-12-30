package dojo.software.crafters;

public class FizzBuzz {

    /*
        Code smells:

        1. Duplications: mapping value Fizz and Buzz are repeated
        2. Somehow also the divisible logic is repeated
        3. Temporal coupling: if we change the order of the ifs the code will not work
     */

    public static String fizzBuzz(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "FizzBuzz";
        }
        if (number % 5 == 0) {
            return "Buzz";
        }
        if (number % 3 == 0) {
            return "Fizz";
        }
        return String.valueOf(number);
    }
}
