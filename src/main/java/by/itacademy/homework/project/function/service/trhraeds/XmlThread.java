package by.itacademy.homework.project.function.service.trhraeds;

import by.itacademy.homework.project.domain.CardOfOwner;
import by.itacademy.homework.project.domain.Teller;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.concurrent.Semaphore;

public class XmlThread extends Teller implements Runnable {
    Semaphore sem = new Semaphore(1);

    public XmlThread(CardOfOwner cardOfOwner) throws IOException, XMLStreamException {
        super(cardOfOwner);
    }

    @Override
    public void run() {
        try {
            sem.acquire();
            if(cardOfOwner.getCards().size()>1) {
                uploadXMLStAX();
                System.out.println("Поток Xml");
                sem.release();}
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
