package by.itacademy.homework.project.function.service.function.sorting;

import by.itacademy.homework.project.domain.Card;

import java.util.Comparator;

public class CardSerchIdComporator implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        return o1.getNumber().compareTo(o2.getNumber());
    }
}
