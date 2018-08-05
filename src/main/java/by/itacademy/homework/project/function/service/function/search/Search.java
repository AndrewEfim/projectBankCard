package by.itacademy.homework.project.function.service.function.search;

import by.itacademy.homework.project.domain.Card;
import by.itacademy.homework.project.domain.CardOfOwner;
import by.itacademy.homework.project.domain.Teller;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Search extends Teller {
    private List<Card>cardList = new ArrayList<>();

    public Search(CardOfOwner cardOfOwner, List<Card> cardList) throws IOException, XMLStreamException {
        super(cardOfOwner, cardList);
    }


//    public List<Card> add() {
//        this.cardList.addAll(cardOfOwner.getCards());
//        return cardList;
//    }
}
