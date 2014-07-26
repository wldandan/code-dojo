package com.wl.dandan.parser;

import com.wl.dandan.model.Taxonomy;
import com.wl.dandan.view.generator.PageGenerator;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class DestinationParser {
    public void parse(InputStream inputStream,
                      Map<Integer, Taxonomy> taxonomyMap,
                      PageGenerator pageGenerator) throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        saxParser.parse(inputStream, new DestinationHandler(taxonomyMap, pageGenerator));
    }
}
