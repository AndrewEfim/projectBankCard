package by.itacademy.homework.project.function.service.trhraeds;

import by.itacademy.homework.project.domain.CardOfOwner;
import by.itacademy.homework.project.domain.Teller;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.concurrent.Semaphore;

public class AllThreads  implements Runnable {
    Semaphore sem = new Semaphore(1);



    @Override
    public void run() {



    }
}
