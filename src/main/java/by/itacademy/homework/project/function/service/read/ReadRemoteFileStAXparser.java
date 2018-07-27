package by.itacademy.homework.project.function.service.read;

import by.itacademy.homework.project.domain.Card;
import by.itacademy.homework.project.domain.CardOfOwner;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.util.*;

public class ReadRemoteFileStAXparser {

    URL link = new URL("http://kiparo.ru/t/bank_card.xml");
    URLConnection connection = link.openConnection();
    InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
    private CardOfOwner cardOfOwner;
    private Set<Card> cards = new HashSet<>();
    private int id;
    private String name;
    private String number;
    private LocalDate year;
    private String remainder;
    private boolean available;

    private boolean bid = false;
    private boolean bname = false;
    private boolean bnumber = false;
    private boolean byear = false;
    private boolean bremainder = false;
    private boolean bavailable = false;
    XMLInputFactory factory = XMLInputFactory.newInstance();
    XMLEventReader eventReader = factory.createXMLEventReader(inputStreamReader);


    public ReadRemoteFileStAXparser() throws IOException, XMLStreamException {
    }


    public Set<Card> execute() throws XMLStreamException {
        while (eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();

            switch (event.getEventType()) {
                case XMLStreamConstants
                        .START_ELEMENT:
                    StartElement startElement = event.asStartElement();
                    String gName = startElement.getName().getLocalPart();
                    if (gName.equalsIgnoreCase("cards")) {
                        Iterator<Attribute> atributes = startElement.getAttributes();
                        //
                        //
                        // }
                    } else if (gName.equalsIgnoreCase("id")) {
                        bid = true;
                    } else if (gName.equalsIgnoreCase("name")) {
                        bname = true;
                    } else if (gName.equalsIgnoreCase("number")) {
                        bnumber = true;
                    } else if (gName.equalsIgnoreCase("year")) {
                        byear = true;
                    } else if (gName.equalsIgnoreCase("remainder")) {
                        bremainder = true;
                    } else if (gName.equalsIgnoreCase("available")) {
                        bavailable = true;
                    }
                    break;

                case XMLStreamConstants.CHARACTERS:
                    Characters characters = event.asCharacters();
                    if (bid) {
                        id = Integer.parseInt(characters.getData());
                        //   System.out.println("id:" + characters.getData());
                        bid = false;
                    }
                    if (bname) {
                        name = characters.getData();
                        // System.out.println("name:" + characters.getData());
                        bname = false;
                    }
                    if (bnumber) {
                        number = characters.getData();
                        //System.out.println("number:" + characters.getData());
                        bnumber = false;
                    }
                    if (byear) {
                        year = LocalDate.parse(characters.getData());
                        //System.out.println("year:" + characters.getData());
                        byear = false;
                    }
                    if (bremainder) {
                        remainder = characters.getData();
                        //System.out.println("remainder:" + characters.getData());
                        bremainder = false;
                    }
                    if (bavailable) {
                        available = Boolean.parseBoolean(characters.getData());
                        // System.out.println("available:" + characters.getData());
                        bavailable = false;
                        cards.add(new Card(id, name, number, year, remainder, available));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    EndElement endElement = event.asEndElement();

                    if (endElement.getName().getLocalPart().equalsIgnoreCase("card")) {
                        cards.add(new Card(id, name, number, year, remainder, available));
                    }
                    break;
            }
        }

        return cards;
    }
}