package by.itacademy.homework.project.function.service.search;

import by.itacademy.homework.project.domain.Card;
import by.itacademy.homework.project.domain.CardOfOwner;
import by.itacademy.homework.project.domain.Teller;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AvailableCardTest {
    private CardOfOwner cardOfOwner = new CardOfOwner();
    private List<Card> cardList = new ArrayList<>();
    private Teller teller = new Teller(cardOfOwner,cardList);

    public AvailableCardTest() throws IOException, XMLStreamException {
    }

    @Test
    public void cardAvailable() throws IOException, XMLStreamException {
        teller.uploadJsonStreAPI();
        teller.uploadXMLStAX();
        cardList.addAll(cardOfOwner.getCards());
        String BankName = "Idea Bank";
        double expResultcountBankCard=1.0;
        double expResultnumberOfCardIssuedId0 = 14.29;

        double reultcountBankCard = 0;
        double resultnumberOfCardIssuedId0=0;
        for (int i = 0; i < cardList.size(); i++) {
            if (cardList.get(i).getName().equals(BankName)) {
                reultcountBankCard++;
                resultnumberOfCardIssuedId0 = (reultcountBankCard / cardList.size()) * 100;

            }
        }
        Assert.assertEquals(expResultcountBankCard,reultcountBankCard,1);
        Assert.assertEquals(expResultnumberOfCardIssuedId0,resultnumberOfCardIssuedId0,1);
    }
}
