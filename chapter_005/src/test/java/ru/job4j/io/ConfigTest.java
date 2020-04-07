package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("name"),
                is("Petr Arsentev")
        );
    }

    @Test
    public void whenPairWithCommentAndBlanks() {
        String path = "./data/pair_with_comments_and_blanks.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("data1"),
                is("text1")
        );
        assertThat(
                config.value("data2"),
                is("text2")
        );
        assertThat(
                config.value("data_empty"),
                is("")
        );
    }


}