package com.wl.dandan;

import com.wl.dandan.model.Taxonomy;
import com.wl.dandan.parser.DestinationParser;
import com.wl.dandan.parser.TaxonomyParser;
import com.wl.dandan.view.generator.AssetsGenerator;
import com.wl.dandan.view.generator.PageGenerator;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

public class Application {

    private Map<Integer, Taxonomy> nodeMap;

    public void initializeTaxonomy(String path) throws IOException, SAXException, ParserConfigurationException {
        nodeMap = new TaxonomyParser().parse(new FileInputStream(new File(path)));
    }

    public void run(String path, PageGenerator pageGenerator) throws IOException, SAXException, ParserConfigurationException {
        AssetsGenerator.cloneAssets(pageGenerator.getOutputDir());
        new DestinationParser().parse(new FileInputStream(new File(path)), nodeMap, pageGenerator);
    }
}