package com.wl.dandan.model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DestinationTest {

    private Destination destination;

    @Before
    public void setUp() throws Exception {
        destination = new Destination(355064, "Africa");
    }

    @Test
    public void should_get_id_and_title() throws Exception {
        assertThat(destination.getAtlasId(), is(355064));
        assertThat(destination.getTitle(), is("Africa"));
    }

    @Test
    public void should_equals_when_two_destination_has_same_id() throws Exception {
        Destination destination2 = new Destination(355064, "Africa");
        assertThat(destination.equals(destination2), is(true));
    }
}
