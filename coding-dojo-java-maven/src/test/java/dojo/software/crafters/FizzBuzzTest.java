package dojo.software.crafters;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static dojo.software.crafters.FizzBuzz.fizzBuzz;
import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {

    @ParameterizedTest(name = "{0} should be {1}")
    @CsvSource({
            "1, 1",
            "2, 2",
            "4, 4"
    })
    void normal_numbers_should_be_printed_as_it_is(int number, String expectedRepresentation) {
        assertThat(fizzBuzz(number)).isEqualTo(expectedRepresentation);
    }

    @ParameterizedTest(name = "{0} should be Fizz")
    @CsvSource({
            "3",
            "6",
            "9"
    })
    void multiples_of_3_should_be_printed_as_Fizz(int number) {
        assertThat(fizzBuzz(number)).isEqualTo("Fizz");
    }

    @ParameterizedTest(name = "{0} should be Buzz")
    @CsvSource({
            "5",
            "10",
            "25"
    })
    void multiples_of_5_should_be_printed_as_Buzz(int number) {
        assertThat(fizzBuzz(number)).isEqualTo("Buzz");
    }

    @ParameterizedTest(name = "{0} should be FizzBuzz")
    @CsvSource({
            "15",
            "45"
    })
    void multiples_of_3_and_5_should_be_printed_as_FizzBuzz(int number) {
        assertThat(fizzBuzz(number)).isEqualTo("FizzBuzz");
    }

}
