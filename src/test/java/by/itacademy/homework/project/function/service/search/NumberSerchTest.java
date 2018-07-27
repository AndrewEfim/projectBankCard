package by.itacademy.homework.project.function.service.search;

import by.itacademy.homework.project.domain.Card;
import by.itacademy.homework.project.domain.CardOfOwner;
import by.itacademy.homework.project.domain.Teller;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NumberSerchTest {
    private CardOfOwner cardOfOwner = new CardOfOwner();
    private List<Card> cardList = new ArrayList<>();
    private Teller teller = new Teller(cardOfOwner);

    public NumberSerchTest() throws IOException, XMLStreamException {
    }

    @Test
    public void shouldbeCardNumberBSBBank() throws IOException, XMLStreamException {
        teller.uploadJsonStreAPI();
        teller.uploadXMLStAX();
        cardList.addAll(cardOfOwner.getCards());
        Card result = null;
        Card expResult = new Card(0, "BSB Bank", "2232 3265 2356 9656", LocalDate.of(2019, 9, 25), "2000", true);
        String cardNumber = "2232 3265 2356 9656";

        for (int i = 0; i < cardList.size(); i++) {
            if (cardList.get(i).getNumber().equals(cardNumber)) {
                result = cardList.get(i);
            }
        }
        Assert.assertEquals(expResult, result);
    }
}
