package by.itacademy.homework.project.function.service.function.sorting;

import by.itacademy.homework.project.domain.Card;

import java.util.Comparator;

public class CardIdComparator implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        if(o1.getId()>o2.getId())return 1;
        else if(o1.getId()<o2.getId())return-1;
        else return 0;
    }
}
