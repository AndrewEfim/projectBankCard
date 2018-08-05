package by.itacademy.homework.project.menu;

import by.itacademy.homework.project.domain.Card;
import by.itacademy.homework.project.domain.CardOfOwner;
import by.itacademy.homework.project.domain.Teller;
import by.itacademy.homework.project.function.service.function.search.*;
import by.itacademy.homework.project.function.service.function.sorting.RemainderSort;
import by.itacademy.homework.project.function.service.function.sorting.YearSort;
import by.itacademy.homework.project.function.service.trhraeds.JsonThread;
import by.itacademy.homework.project.function.service.trhraeds.XmlThread;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class Menu {
    private CardOfOwner cardOfOwner = new CardOfOwner();
    public List<Card> cardList = new ArrayList<>();
    private Teller teller = new Teller(cardOfOwner,cardList);
    private AvailableCard availableCard = new AvailableCard(cardOfOwner,cardList);
    private Search search = new Search(cardOfOwner,cardList);
    private Map<Integer, Comand> menuitems = new HashMap<>();

    public void upload() throws XMLStreamException, IOException {
        teller.uploadXMLStAX();
        teller.uploadJsonStreAPI();
        teller.add();
        //System.out.println(search.add().size());
    }

    {
        System.out.println("Банковские карты");
        //Thread thread = new Thread(new JsonThread(cardOfOwner));
        //thread.start();
        //Thread thread1 = new Thread(new XmlThread(cardOfOwner));
        //thread1.start();

        boolean f = true;

        menuitems.put(1, new RemainderSort(cardOfOwner,cardList));
        menuitems.put(2, new YearSort(cardOfOwner,cardList));
        menuitems.put(3, new BankCardValid(cardOfOwner,cardList));
        menuitems.put(4, new TimeRangeSearch(cardOfOwner,cardList));
        menuitems.put(5, new AvailableCard(cardOfOwner,cardList));
        menuitems.put(6, new NumberSearch(cardOfOwner,cardList));
    }

    public Menu() throws IOException, XMLStreamException {
    }

    public Comand getComand(int i) {
        return menuitems.get(i);
    }

    public void textMenu() {
        System.out.println("1- сортировка по остатку");
        System.out.println("2- сорировка по году");
        System.out.println("3- узнать сколько еще карта действительна");
        System.out.println("4- поиск по временному диапазону");
        System.out.println("5- узнать сколько карт банка в наличии и процент от общего количесво");
        System.out.println("6- поиск по номеру карты");
        System.out.println("7- выход");
    }
}
