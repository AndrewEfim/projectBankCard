package by.itacademy.homework.project.function.service.trhraeds;

import by.itacademy.homework.project.domain.CardOfOwner;
import by.itacademy.homework.project.domain.Teller;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.concurrent.Semaphore;

public class JsonThread extends Teller implements Runnable {
    Semaphore sem = new Semaphore(1);

    public JsonThread(CardOfOwner cardOfOwner) throws IOException, XMLStreamException {
        super(cardOfOwner);
    }

    @Override
    public void run() {
        try {
            sem.acquire();
            if(cardOfOwner.getCards().isEmpty()){
            uploadJsonStreAPI();
            System.out.println("Поток Json");
            sem.release();}

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //должен запускать чтение Json


    }
}
