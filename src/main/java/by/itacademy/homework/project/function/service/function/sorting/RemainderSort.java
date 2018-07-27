package by.itacademy.homework.project.function.service.function.sorting;

import by.itacademy.homework.project.domain.Card;
import by.itacademy.homework.project.domain.CardOfOwner;
import by.itacademy.homework.project.domain.Teller;
import by.itacademy.homework.project.menu.Comand;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.*;

public class RemainderSort extends Teller implements Comand {

    public RemainderSort(CardOfOwner cardOfOwner) throws IOException, XMLStreamException {
        super(cardOfOwner);
    }
    //SortByRemainder
    public void execute() {
        Set<Card> cardsRmndr = new TreeSet<>(new CardRemainderComparator());
        cardsRmndr.addAll(cardOfOwner.getCards());
        System.out.println("Сортировка по остатку: "+cardsRmndr);
    }
}
