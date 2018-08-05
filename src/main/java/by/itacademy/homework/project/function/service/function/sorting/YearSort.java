package by.itacademy.homework.project.function.service.function.sorting;

import by.itacademy.homework.project.domain.Card;
import by.itacademy.homework.project.domain.CardOfOwner;
import by.itacademy.homework.project.domain.Teller;
import by.itacademy.homework.project.menu.Comand;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.*;

public class YearSort extends Teller implements Comand {

    public YearSort(CardOfOwner cardOfOwner, List<Card> cardList) throws IOException, XMLStreamException {
        super(cardOfOwner, cardList);
    }

    //SortingByYear
    public void execute() {
        Set<Card> cardsYear = new TreeSet<>(new CardYearComparator());
        cardsYear.addAll(cardOfOwner.getCards());
        System.out.println("Сортировка по году: " + cardsYear);
    }
}
