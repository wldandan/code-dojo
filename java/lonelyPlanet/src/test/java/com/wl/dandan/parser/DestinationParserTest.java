package com.wl.dandan.parser;

import com.wl.dandan.model.Destination;
import com.wl.dandan.model.Taxonomy;
import com.wl.dandan.view.element.Page;
import com.wl.dandan.view.generator.PageGenerator;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Map;

import static junit.framework.Assert.assertNull;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class DestinationParserTest {

    InputStream in;
    Map<Integer, Taxonomy> maps;
    PageGenerator pageGenerator;
    Destination destination;
    Taxonomy taxonomy;
    Page page;

    @Before
    public void setUp() throws Exception {
        in = TaxonomyParserTest.class.getClassLoader().getResourceAsStream("single_node.xml");
        maps = new TaxonomyParser().parse(in);
        destination = new Destination(355064, "Africa");
        taxonomy = maps.get(355064);

        pageGenerator = mock(PageGenerator.class);
        page = mock(Page.class);

        doNothing().when(pageGenerator).generateHtml(destination, taxonomy);
    }

    @Test
    public void should_call_page_builder_to_build_page() throws Exception {
        in = DestinationParserTest.class.getClassLoader().getResourceAsStream("multiple_destinations.xml");
        new DestinationParser().parse(in, maps, pageGenerator);
        verify(pageGenerator).generateHtml(destination, taxonomy);
    }
}