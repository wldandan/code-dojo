package com.wl.dandan.view.generator;

import com.wl.dandan.view.element.Page;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TemplateEngineTest {

    Page page = mock(Page.class);

    @Test
    public void should_get_one_instance_about_template_engine() throws Exception {
        TemplateEngine engine = TemplateEngine.getInstance();
        TemplateEngine engine2 = TemplateEngine.getInstance();

        assertThat(engine, is(engine2));
    }

    @Test
    public void should_call_page_to_render() throws Exception {
        TemplateEngine engine = TemplateEngine.getInstance();
        engine.render(page, "/tmp/test/generated");

        verify(page).getChildrenNavigations();
        verify(page).getDestination();
        verify(page).getParentNavigations();
        verify(page).getOutputDir();
    }
}
