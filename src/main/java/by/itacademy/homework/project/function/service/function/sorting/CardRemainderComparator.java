package by.itacademy.homework.project.function.service.function.sorting;

import by.itacademy.homework.project.domain.Card;

import java.util.Comparator;

public class CardRemainderComparator implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        if (Integer.parseInt(o1.getRemainder()) < Integer.parseInt(o2.getRemainder())) return -1;
        if (Integer.parseInt(o1.getRemainder()) > Integer.parseInt(o2.getRemainder())) return 1;
        else return 0;
    }
}
