package dojo;

import org.junit.jupiter.api.Test;

import static dojo.FizzBuzz.fizzBuzz;
import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {

    @Test
    void one_should_print_one() {
        assertThat(fizzBuzz(1)).isEqualTo("1");
    }
}
