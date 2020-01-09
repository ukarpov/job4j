package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    @Test
    public void whenGetAddresses() {
        var adr1 = new Address("City1", "Street1", 1, 100);
        var adr2 = new Address("City2", "Street2", 2, 200);
        var adr3 = new Address("City3", "Street3", 3, 300);
        var profiles = Arrays.asList(new Profile(adr1), new Profile(adr2), new Profile(adr3));
        var allAddr = Profiles.collect(profiles);
        assertThat(allAddr, is(Arrays.asList(adr1, adr2, adr3)));
    }

    @Test
    public void whenDistinctAndSorted() {
        var adr1 = new Address("City3", "Street3", 3, 300);
        var adr2 = new Address("City1", "Street1", 1, 100);
        var adr3 = new Address("City1", "Street1", 1, 100);
        var adr4 = new Address("City1", "Street1", 1, 100);
        var adr5 = new Address("City2", "Street2", 2, 200);
        var profiles = Arrays.asList(new Profile(adr1), new Profile(adr2), new Profile(adr3), new Profile(adr4), new Profile(adr5));
        var allAddr = Profiles.collect(profiles);
        assertThat(allAddr, is(Arrays.asList(adr2, adr5, adr1)));
    }
}
