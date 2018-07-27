package by.itacademy.homework.project.function.service.function.sorting;

import by.itacademy.homework.project.domain.Card;

import java.util.Comparator;

public class CardYearComparator<C> implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        return o1.getYear().compareTo(o2.getYear());
    }
}
