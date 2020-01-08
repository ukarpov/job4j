package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    @Test
    public void whenGetAddresses() {
        Address adr1 = new Address("City1", "Street1", 1, 100);
        Address adr2 = new Address("City2", "Street2", 2, 200);
        Address adr3 = new Address("City3", "Street3", 3, 300);
        List<Profile> profiles = Arrays.asList(new Profile(adr1), new Profile(adr2), new Profile(adr3));
        List<Address> allAddr = Profiles.collect(profiles);
        assertThat(allAddr, is(Arrays.asList(adr1, adr2, adr3)));
    }
}
