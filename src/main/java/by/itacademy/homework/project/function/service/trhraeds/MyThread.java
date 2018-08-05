package by.itacademy.homework.project.function.service.trhraeds;

import by.itacademy.homework.project.domain.CardOfOwner;
import by.itacademy.homework.project.domain.iTeller;
import by.itacademy.homework.project.function.service.read.ReadRemoteFileStAXparser;
import by.itacademy.homework.project.function.service.read.ReadRemoteFileStreAPI;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.concurrent.Semaphore;

public class MyThread extends Thread implements iTeller {

    private ReadRemoteFileStreAPI readRemoteFileStreAPI = new ReadRemoteFileStreAPI();
    private ReadRemoteFileStAXparser readRemoteFileStAXparser = new ReadRemoteFileStAXparser();
    private CardOfOwner cardOfOwner;
    private final Semaphore semaphore;

    public MyThread (CardOfOwner cardOfOwner ,Semaphore semaphore) throws IOException, XMLStreamException {
        this.semaphore = semaphore;
        this.cardOfOwner=cardOfOwner;
    }

    @Override
    public void run() {
        try {
            readFile();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println(getName()+ "interrupted");
        }
    }

    private void readFile() throws InterruptedException, XMLStreamException, IOException {
        semaphore.acquire();
        try {
            System.out.println(getName()+ "acuquire semaphore");
            uploadXMLStAX();
            uploadJsonStreAPI();
        } finally {
            System.out.println( getName()+ "relese semaphore");
            semaphore.release();
        }
    }

    @Override
    public CardOfOwner uploadJsonStreAPI() throws IOException {
        cardOfOwner.addAll(readRemoteFileStreAPI.execute());
        return cardOfOwner;
    }

    @Override
    public CardOfOwner uploadXMLStAX() throws XMLStreamException {
        cardOfOwner.addAll(readRemoteFileStAXparser.execute());
        return cardOfOwner;
    }
}
