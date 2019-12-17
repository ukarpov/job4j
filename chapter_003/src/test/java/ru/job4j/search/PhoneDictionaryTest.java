package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFindByPhone() {
        PhoneDictionary phones = new PhoneDictionary();
        Person p1 = new Person("Petr", "Arsentev", "534872", "Bryansk");
        Person p2 = new Person("Yuriy", "Karpov", "872435", "Moscow");
        Person p3 = new Person("Vasia", "Poopkin", "1111", "Samara");
        phones.add(p1);
        phones.add(p2);
        phones.add(p3);
        ArrayList<Person> expected = new ArrayList<Person>();
        expected.add(p1);
        expected.add(p2);
        ArrayList<Person> persons = phones.find("872");
        assertTrue(persons.equals(expected));
    }
}
