package dojo.software.crafters;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static dojo.software.crafters.FizzBuzz.fizzBuzz;
import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {

    @ParameterizedTest(name = "{0} should be mapped to {1}")
    @CsvSource({
            "1, 1",
            "2, 2",
            "4, 4",
            "3, Fizz",
            "6, Fizz",
            "5, Buzz",
            "10, Buzz",
            "15, FizzBuzz"
    })
    void fizz_buzz_should_work(int number, String expected) {
        assertThat(fizzBuzz(number)).isEqualTo(expected);
    }
}
