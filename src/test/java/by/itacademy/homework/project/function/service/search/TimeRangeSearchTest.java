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

public class TimeRangeSearchTest {

    private CardOfOwner cardOfOwner = new CardOfOwner();
    private List<Card> cardList = new ArrayList<>();
    private Teller teller = new Teller(cardOfOwner,cardList);

    public TimeRangeSearchTest() throws IOException, XMLStreamException {
    }

    @Test
    public void shuldbeeMosckvaMinskBank() throws IOException, XMLStreamException {
        teller.uploadJsonStreAPI();
        teller.uploadXMLStAX();
        cardList.addAll(cardOfOwner.getCards());
        LocalDate startRange = LocalDate.parse("2021-08-31");
        LocalDate endRange = LocalDate.parse("2021-09-03");
        Card tresult = null;
        Card expResult = new Card(1, "Moskva_Minsk Bank", "2212 3265 2356 9126", LocalDate.of(2021, 9, 01), "500", true);

        for (int i = 0; i < cardList.size(); i++) {
            if ((startRange.isBefore(cardList.get(i).getYear())) && ((endRange).isAfter(cardList.get(i).getYear()))) {
                tresult = cardList.get(i);
            }
        }
        Assert.assertEquals(expResult, tresult);
    }
}
