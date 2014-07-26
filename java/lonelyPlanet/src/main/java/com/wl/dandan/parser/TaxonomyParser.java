package com.wl.dandan.parser;

import com.wl.dandan.model.Taxonomy;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class TaxonomyParser {
    private final TaxonomyHandler handler;

    public TaxonomyParser() {
        this.handler = new TaxonomyHandler();
    }

    public Map<Integer, Taxonomy> parse(InputStream inputStream) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        saxParser.parse(inputStream, handler);
        return handler.getTaxonomyMap();
    }

}
