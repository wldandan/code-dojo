package com.tw.wldandan;

import com.tw.wldandan.utils.Utils;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class UtilTest {

    @Test
    public void testParseDay() throws Exception {
        assertThat(Utils.parseDay("20Mar2009(fri)"), is("fri"));
    }
}
