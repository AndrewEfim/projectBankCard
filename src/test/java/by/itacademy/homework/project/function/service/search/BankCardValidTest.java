package by.itacademy.homework.project.function.service.search;

import by.itacademy.homework.project.domain.Card;
import by.itacademy.homework.project.domain.CardOfOwner;
import by.itacademy.homework.project.domain.Teller;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class BankCardValidTest {
    private CardOfOwner cardOfOwner = new CardOfOwner();
    private List<Card> cardList = new ArrayList<>();
    private Teller teller = new Teller(cardOfOwner);

    public BankCardValidTest() throws IOException, XMLStreamException {
    }

    @Test
    public void sholdBeTimeValid318() throws IOException, XMLStreamException {
        teller.uploadJsonStreAPI();
        teller.uploadXMLStAX();
        cardList.addAll(cardOfOwner.getCards());
        int index = Integer.parseInt("1");
        LocalDate now = LocalDate.now();
        int resultY = 0;
        int resultM = 0;
        int resultD = 0;
        Period periodexpRes = Period.between(now,cardList.get(2).getYear());
        int expresultY = periodexpRes.getYears();
        int expresultM = periodexpRes.getMonths();
        int expresultD = periodexpRes.getDays();
        for (int i = 0; i < cardList.size(); i++) {
            if (cardList.get(i).getId() == index) {
                Period period = Period.between(now, cardList.get(i).getYear());
                resultY = period.getYears();
                resultM = period.getMonths();
                resultD = period.getDays();
            }
        }
        Assert.assertEquals(expresultY, resultY);
        Assert.assertEquals(expresultM, resultM);
        Assert.assertEquals(expresultD, resultD);
    }
}

