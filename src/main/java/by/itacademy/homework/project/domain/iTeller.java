package by.itacademy.homework.project.domain;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public interface iTeller {

    CardOfOwner uploadJsonStreAPI() throws IOException;

    CardOfOwner uploadXMLStAX() throws XMLStreamException;
}
