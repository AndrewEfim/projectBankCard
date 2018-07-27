package by.itacademy.homework.project.domain;

import java.util.*;

public class CardOfOwner {
    private Set<Card> cards = new HashSet<>();

    public void add(Card card) {
        cards.remove(card);
        cards.add(card);

    }

    public void addAll(Set<Card> cards) {
        this.cards.removeAll(cards);
        this.cards.addAll(cards);

    }

    public Set<Card> getCards() {

        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "CardOfOwner{" +
                "cards=" + cards +
                '}';
    }
}
