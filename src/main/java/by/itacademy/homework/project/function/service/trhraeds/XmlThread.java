package by.itacademy.homework.project.function.service.trhraeds;

import by.itacademy.homework.project.domain.Card;
import by.itacademy.homework.project.domain.CardOfOwner;
import by.itacademy.homework.project.domain.Teller;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.Semaphore;

public class XmlThread extends Teller implements Runnable {
    public XmlThread(CardOfOwner cardOfOwner, List<Card> cardList) throws IOException, XMLStreamException {
        super(cardOfOwner, cardList);
    }
    // Semaphore sem = new Semaphore(2);


    @Override
    public void run() {
        try {
            sem.acquire(1);
            uploadXMLStAX();
            Thread.sleep(100);
            System.out.println("Поток Xml" + Thread.activeCount());
            sem.release(1);

        } catch (
                InterruptedException e)

        {
            e.printStackTrace();
        } catch (
                XMLStreamException e)

        {
            e.printStackTrace();
        }
    }
}
