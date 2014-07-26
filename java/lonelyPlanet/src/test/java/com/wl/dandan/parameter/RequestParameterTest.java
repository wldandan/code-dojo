package com.wl.dandan.parameter;

import org.junit.Before;
import org.junit.Test;

public class RequestParameterTest {

    private RequestParameter parameter;

    @Before
    public void setUp() throws Exception {
        parameter = new RequestParameter();
    }

    @Test(expected=IllegalArgumentException.class)
    public void should_throw_exception_when_destination_file_path_is_null() {
        parameter.setTaxonomyFilePath("taxonomy_file_path");
        parameter.setOutputDir("output_directory");
        parameter.validate();
    }

    @Test(expected=IllegalArgumentException.class)
    public void should_throw_exception_when_taxonomy_file_path_is_null() throws Exception {
        parameter.setDestinationFilePath("destination_file_path");
        parameter.setOutputDir("output_directory");
        parameter.validate();
    }

    @Test(expected=IllegalArgumentException.class)
    public void should_throw_exception_when_output_file_path_is_null() throws Exception {
        parameter.setDestinationFilePath("destination_file_path");
        parameter.setTaxonomyFilePath("taxonomy_file_path");
        parameter.validate();
    }
}
