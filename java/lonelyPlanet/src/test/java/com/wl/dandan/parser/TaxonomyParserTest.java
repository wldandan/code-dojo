package com.wl.dandan.parser;

import com.wl.dandan.model.Taxonomy;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Map;

import static junit.framework.Assert.assertNull;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class TaxonomyParserTest {

    InputStream in;
    TaxonomyParser taxonomyParser;

    @Before
    public void setUp() throws Exception {
        taxonomyParser = new TaxonomyParser();
    }

    @Test
    public void should_parse_single_node_with_id_and_name_map() throws Exception {
        in = TaxonomyParserTest.class.getClassLoader().getResourceAsStream("single_node.xml");
        Map<Integer, Taxonomy> maps = taxonomyParser.parse(in);

        assertThat(maps.size(), is(1));
        assertThat(maps.keySet().contains(355064), is(true));
        assertThat(maps.get(355064).getName(), is("Africa"));
    }

    @Test
    public void should_parse_multiple_nodes_with_different_level() throws Exception {
        in = TaxonomyParserTest.class.getClassLoader().getResourceAsStream("multiple_node.xml");
        Map<Integer, Taxonomy> maps = taxonomyParser.parse(in);

        assertThat(maps.size(), is(4));

        assertThat(maps.keySet().contains(355064), is(true));
        assertThat(maps.get(355064).getName(), is("Africa"));
        assertThat(maps.get(355064).getChildren().size(), is(1));
        assertNull(maps.get(355064).getParent());

        assertThat(maps.keySet().contains(355611), is(true));
        assertThat(maps.get(355611).getName(), is("South Africa"));
        assertThat(maps.get(355611).getChildren().size(), is(1));
        assertThat(maps.get(355611).getParent().getId(), is(355064));

        assertThat(maps.keySet().contains(355612), is(true));
        assertThat(maps.get(355612).getName(), is("Cape Town"));
        assertThat(maps.get(355612).getChildren().size(), is(1));
        assertThat(maps.get(355612).getParent().getId(), is(355611));

        assertThat(maps.keySet().contains(355613), is(true));
        assertThat(maps.get(355613).getName(), is("Table Mountain National Park"));
        assertThat(maps.get(355613).getChildren().isEmpty(), is(true));
        assertThat(maps.get(355613).getParent().getId(), is(355612));
    }

}