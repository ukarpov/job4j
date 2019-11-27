package ru.job4j.tracker;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"invalid", "0"})
        );
        input.askInt("Enter", 1);
        assertThat(
                new String(mem.toByteArray()),
                is(String.format("Please enter validate data again ") + System.lineSeparator())
        );
        System.setOut(out);
    }

    @Test
    public void whenInvalidMenuKey() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"5", "0"})
        );
        input.askInt("Enter", 1);
        assertThat(
                new String(mem.toByteArray()),
                is(String.format("Please select key from menu ") + System.lineSeparator())
        );
        System.setOut(out);
    }
}
