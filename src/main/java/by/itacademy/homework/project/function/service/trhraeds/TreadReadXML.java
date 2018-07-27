package by.itacademy.homework.project.function.service.trhraeds;

import by.itacademy.homework.project.domain.CardOfOwner;
import by.itacademy.homework.project.domain.Teller;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.concurrent.Semaphore;

public class TreadReadXML implements Runnable {

    private CardOfOwner cardOfOwner = new CardOfOwner();
    private Teller teller = new Teller(cardOfOwner);
    String name;
    Semaphore semaphore;

    public TreadReadXML(String name, Semaphore semaphore) throws IOException, XMLStreamException {
        this.name = name;
        this.semaphore = semaphore;

        new Thread(this).start();
    }

    public void run() {
        System.out.println("Запуск потока" + name);

        try {
            System.out.println("Поток ожидает разрешения" + name);
            semaphore.acquire();
            System.out.println("Поток получает разрешение" + name);

         while (cardOfOwner.getCards().isEmpty()) {
                teller.uploadXMLStAX();
                //teller.uploadJsonStreAPI();

                //  System.out.println(cardOfOwner);

                Thread.sleep(10);
            }
        } catch (InterruptedException exc) {
            System.out.println(exc);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        System.out.println("Поток освобождает разрешение" + name);

        semaphore.release();
    }

    public CardOfOwner getCardOfOwner() {
        return cardOfOwner;
    }
}
