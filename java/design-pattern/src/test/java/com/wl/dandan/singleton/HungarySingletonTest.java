package com.wl.dandan.singleton;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HungarySingletonTest {

    @Test
    public void testGetInstance() throws Exception {
        assertThat(HungarySingleton.getInstance(), is(HungarySingleton.class));
        assertThat(HungarySingleton.getInstance(), is(HungarySingleton.getInstance()));
    }
}
