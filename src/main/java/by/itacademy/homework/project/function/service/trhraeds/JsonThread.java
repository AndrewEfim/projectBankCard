package by.itacademy.homework.project.function.service.trhraeds;

import by.itacademy.homework.project.domain.Card;
import by.itacademy.homework.project.domain.CardOfOwner;
import by.itacademy.homework.project.domain.Teller;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Semaphore;

public class JsonThread extends Teller implements Runnable {
    public JsonThread(CardOfOwner cardOfOwner, List<Card> cardList) throws IOException, XMLStreamException {
        super(cardOfOwner, cardList);
    }
    // Semaphore sem = new Semaphore(1);


    @Override
    public void run() {
        try {

            sem.acquire(1);
            uploadJsonStreAPI();
            Thread.sleep(100);
            System.out.println("Поток Json"+Thread.activeCount());
            sem.release(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //должен запускать чтение Json


    }
}
