package dojo.software.crafters;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static dojo.software.crafters.FizzBuzz.fizzBuzz;
import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {

    @ParameterizedTest(name = "{0} should be {1}")
    @CsvSource(value = {
            "1, 1",
            "2, 2",
            "4, 4",
            "3, Fizz",
            "9, Fizz",
            "12, Fizz",
            "5, Buzz",
            "25, Buzz",
            "15, FizzBuzz",
            "45, FizzBuzz"
    })
    void fizzBuzz_should_work(int number, String expected) {
        assertThat(fizzBuzz(number)).isEqualTo(expected);
    }
}
