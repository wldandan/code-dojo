package com.wl.dandan.model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TaxonomyTest {

    private Taxonomy taxonomy;

    @Before
    public void setUp() throws Exception {
        taxonomy = new Taxonomy(355064);
    }

    @Test
    public void should_get_id() {
        assertThat(taxonomy.getId(), is(355064));
    }

    @Test
    public void should_attatch_to_parent() throws Exception {
        Taxonomy parentTaxonomy = new Taxonomy(355061);
        taxonomy.attachToParent(parentTaxonomy);

        assertThat(taxonomy.getParent(), is(parentTaxonomy));
        assertThat(parentTaxonomy.getChildren().size(), is(1));
        assertThat(parentTaxonomy.getChildren().get(0), is(taxonomy));
    }

    @Test
    public void should_equals_when_two_destination_has_same_id() throws Exception {
        Taxonomy taxonomy2 = new Taxonomy(355064);
        assertThat(taxonomy.equals(taxonomy2), is(true));
    }

}
