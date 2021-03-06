package by.itacademy.homework.project.domain;

import by.itacademy.homework.project.function.service.read.ReadRemoteFileStAXparser;
import by.itacademy.homework.project.function.service.read.ReadRemoteFileStreAPI;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Teller {
    public Semaphore sem = new Semaphore(1);
    public CardOfOwner cardOfOwner;// = new CardOfOwner();
    public List<Card> cardList = new ArrayList<>();
    private ReadRemoteFileStreAPI readRemoteFileStreAPI = new ReadRemoteFileStreAPI();
    private ReadRemoteFileStAXparser readRemoteFileStAXparser = new ReadRemoteFileStAXparser();

    public Teller(CardOfOwner cardOfOwner,List<Card> cardList  ) throws IOException, XMLStreamException {
        this.cardOfOwner = cardOfOwner;
        this.cardList = cardList;
    }

    public Teller() throws IOException, XMLStreamException {
    }

    public   CardOfOwner uploadJsonStreAPI() throws IOException {
        cardOfOwner.addAll(readRemoteFileStreAPI.execute());
        return cardOfOwner;
    }

    public   CardOfOwner uploadXMLStAX() throws XMLStreamException {
        cardOfOwner.addAll(readRemoteFileStAXparser.execute());
        return cardOfOwner;
    }

    public CardOfOwner getCardOfOwner() {
        return cardOfOwner;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public List<Card> add(){
        cardList.addAll(cardOfOwner.getCards());
        System.out.println(cardList.size());
        return cardList;
    }
}




