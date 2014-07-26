package com.wl.dandan.parser;

import com.wl.dandan.model.Destination;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class DestinationSTAXParser {

    Destination destination;

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        new DestinationSTAXParser().parseXML("/Users/leiwang/Learning/spikes/java/lonelyPlanet/src/main/resources/destinations.xml");
    }


    private void parseXML(String fileName) throws FileNotFoundException, XMLStreamException {

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLStreamReader streamReader = xmlInputFactory.createXMLStreamReader(new FileInputStream(fileName));
        while (streamReader.hasNext()) {
            streamReader.next();
            if (streamReader.getEventType() == XMLStreamReader.START_ELEMENT) {
                String elementName = streamReader.getLocalName();
                if ("destination".equals(elementName)) {
                    parseDestination(streamReader);
                }
            }
        }
    }

    private void parseDestination(XMLStreamReader streamReader) throws XMLStreamException {
        while(streamReader.hasNext()){
            streamReader.next();

            if(streamReader.getEventType() == XMLStreamReader.END_ELEMENT){
                String elementName = streamReader.getLocalName();
                if("destination".equals(elementName)){
                }
            } else if(streamReader.getEventType() == XMLStreamReader.START_ELEMENT){
                String elementName = streamReader.getLocalName();
                if ("history".equals(elementName)) {
                    parseDestination(streamReader);
                }
            }
        }
    }

    private void parseHistory(XMLStreamReader streamReader){

    }
}
