package dojo.software.crafters;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static dojo.software.crafters.FizzBuzz.fizzBuzz;
import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {

    @ParameterizedTest(name = "{index}° test case - {0} should be mapped to {1}")
    @CsvSource({
            "1, 1",
            "2, 2"
    })
    void fizz_buzz_should_work(int number, String expected) {
        assertThat(fizzBuzz(number)).isEqualTo(expected);
    }
}
