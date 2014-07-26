package com.wl.dandan.parser;

import com.wl.dandan.model.Destination;
import com.wl.dandan.model.Taxonomy;
import com.wl.dandan.view.generator.PageGenerator;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.wl.dandan.Utils.getInt;
import static com.wl.dandan.Utils.getString;

public class DestinationHandler extends DefaultHandler {
    private final StringBuilder buffer = new StringBuilder();

    private final String DESTINATION_OBJECT = "destination";
    private final String ATTR_ID = "atlas_id";
    private final String ATTR_TITLE = "title";

    private final String INTRODUCTION_OBJECT = "introduction";
    private final String OVERVIEW_OBJECT = "overview";
    private final String HISTORY_OBJECT = "history";
    private final String INFORMATION_OBJECT = "practical_information";
    private final String TRANSPORT_OBJECT = "transport";

    private Integer isIntroductionPhase = 0;
    private Integer isInformationPhase = 0;
    private Integer isHistoryPhase = 0;
    private Integer isTransportPhase = 0;

    private PageGenerator pageGenerator;

    private Destination currentDestination;
    private Map<Integer, Taxonomy> taxonomyMap = new HashMap();
    private String currentQName = "";


    public DestinationHandler(Map<Integer, Taxonomy> taxonomyMap, PageGenerator pageGenerator) {
        this.taxonomyMap = taxonomyMap;
        this.pageGenerator = pageGenerator;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (DESTINATION_OBJECT.equals(qName)) {
            currentDestination = new Destination(getInt(attributes, ATTR_ID), getString(attributes, ATTR_TITLE));
        }
        else if (INTRODUCTION_OBJECT.equals(qName)) {
            isIntroductionPhase=+1;
        }
        else if (INFORMATION_OBJECT.equals(qName)) {
            isInformationPhase=+1;
        }
        else if (HISTORY_OBJECT.equals(qName)) {
            isHistoryPhase= isHistoryPhase + 1;
        }
        else if (TRANSPORT_OBJECT.equals(qName)){
            isTransportPhase = isTransportPhase + 1;
        }

        currentQName = qName;

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (DESTINATION_OBJECT.equals(qName)) {
            Taxonomy taxonomy = taxonomyMap.get(currentDestination.getAtlasId());
            pageGenerator.generateHtml(currentDestination, taxonomy);
            currentDestination = null;
        }
        else if (HISTORY_OBJECT.equals(qName)) {
            currentDestination.addHistory(getBufferValue());
            isHistoryPhase = isHistoryPhase - 1;
        }
        else if (INTRODUCTION_OBJECT.equals(qName)) {
            isIntroductionPhase = isIntroductionPhase - 1;
        }
        else if (INFORMATION_OBJECT.equals(qName)){
            isInformationPhase = isInformationPhase - 1;
        }
        else if (TRANSPORT_OBJECT.equals(qName)){
            isTransportPhase = isTransportPhase - 1;
        }

        else if ((isInformationPhase > 0)) {
            currentDestination.addInformation(getBufferValue());
        }
        else if (isTransportPhase > 0 ){
            currentDestination.addTransportation(getBufferValue());
        }
        else if (OVERVIEW_OBJECT.equals(qName)) {
            if (isIntroductionPhase > 0){
                currentDestination.setOverview(getBufferValue());
            }
            else if (isHistoryPhase > 0){
                currentDestination.addHistoryOverview(getBufferValue());
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(new String(ch, start, length));
    }

    private String getBufferValue() {
        String result = buffer.toString().trim();
        buffer.setLength(0);

        return result;
    }
}