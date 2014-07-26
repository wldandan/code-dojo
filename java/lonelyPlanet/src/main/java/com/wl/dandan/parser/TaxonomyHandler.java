package com.wl.dandan.parser;

import com.wl.dandan.model.Taxonomy;
import org.apache.commons.collections.map.LinkedMap;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static com.wl.dandan.Utils.getInt;

public class TaxonomyHandler extends DefaultHandler {
    private final StringBuilder buffer = new StringBuilder();

    private final String NODE_OBJECT = "node";
    private final String NODE_NAME   = "node_name";
    private final String ATTR_ID     = "atlas_node_id";

    private LinkedMap taxonomyMap = new LinkedMap(new HashMap<Integer, Taxonomy>());
    private Stack<Taxonomy> references = new Stack();


    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {

        if (NODE_OBJECT.equals(qName)) {
            Taxonomy currentTaxonomy = new Taxonomy(getInt(attributes, ATTR_ID));

            Taxonomy parentTaxonomy = getParentNode();
            if (parentTaxonomy != null){
                currentTaxonomy.attachToParent(parentTaxonomy);
            }
            references.push(currentTaxonomy);
            taxonomyMap.put(currentTaxonomy.getId(), currentTaxonomy);
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (NODE_OBJECT.equals(qName)) {
            references.pop();
        }
        else if (NODE_NAME.equals(qName)) {
            references.peek().setName(getBufferValue());
        }

        buffer.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    private Taxonomy getParentNode() {
        if (references.isEmpty()){
            return null;
        }
        return references.peek();
    }

    private String getBufferValue() {
        if (buffer.length() == 0){
            return null;
        }
        return buffer.toString().trim();
    }

    public Map<Integer, Taxonomy> getTaxonomyMap() {
        return Collections.unmodifiableMap(taxonomyMap);
    }
}