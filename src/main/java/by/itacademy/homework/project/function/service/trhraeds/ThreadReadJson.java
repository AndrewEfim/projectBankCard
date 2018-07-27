package by.itacademy.homework.project.function.service.trhraeds;

import by.itacademy.homework.project.domain.Card;
import by.itacademy.homework.project.domain.CardOfOwner;
import by.itacademy.homework.project.domain.Teller;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class ThreadReadJson implements Runnable {
    CardOfOwner cardOfOwner;// = new CardOfOwner();
    Teller teller ;//= new Teller(cardOfOwner);
    Set<Card>cards = new HashSet<>();
    String name;


    Semaphore semaphore;

    public ThreadReadJson(String name, Semaphore semaphore) throws IOException, XMLStreamException {
        this.name = name;
        this.semaphore = semaphore;

        new Thread(this).start();
    }


    public void run() {
            System.out.println("Запуск");
            try {
                System.out.println("Поток ожидает разрешения");
                semaphore.acquire();
                System.out.println("Поток получает разрешение");

                if (cardOfOwner.getCards().isEmpty()) {
                    Thread.sleep(1);
                }
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }
        System.out.println("Поток освобождает разрешение");
            semaphore.release();


        }

    public CardOfOwner getCardOfOwner() {
        return cardOfOwner;
    }
}

