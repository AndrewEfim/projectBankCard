package by.itacademy.homework.project.function.service.sorting;

import by.itacademy.homework.project.domain.Card;
import by.itacademy.homework.project.domain.CardOfOwner;
import by.itacademy.homework.project.domain.Teller;
import by.itacademy.homework.project.function.service.function.sorting.CardRemainderComparator;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class RemainderSortTest {

    private CardOfOwner cardOfOwner = new CardOfOwner();
    private List<Card> cardList = new ArrayList<>();
    private Set<Card> cardsRmndr = null;
    private Set<Card> cardsRmndrExpResult = new TreeSet<>(new CardRemainderComparator());
    private Teller teller = new Teller(cardOfOwner,cardList);

    {
        cardsRmndrExpResult.add(new Card(4, "BPS Sber Bank", "2299 3565 2565 9776", LocalDate.of(2016, 01, 23), "10", false));
        cardsRmndrExpResult.add(new Card(5, "Idea Bank", "2569 5662 2565 5697", LocalDate.of(2019, 01, 25), "50", true));
        cardsRmndrExpResult.add(new Card(2, "Belarus Bank", "2231 3266 2356 9655", LocalDate.of(2019, 07, 25), "1000", true));
        cardsRmndrExpResult.add(new Card(0, "BSB Bank", "2232 3265 2356 9656", LocalDate.of(2019, 9, 25), "2000", true));
        cardsRmndrExpResult.add(new Card(3, "Alpha Bank", "2232 3265 6565 5696", LocalDate.of(2020, 06, 01), "100", true));
        cardsRmndrExpResult.add(new Card(1, "Moskva_Minsk Bank", "2212 3265 2356 9126", LocalDate.of(2021, 9, 01), "500", true));
        cardsRmndrExpResult.add(new Card(4, "BPS Sber Bank", "2299 3565 2565 9776", LocalDate.of(2022, 01, 23), "10", false));
    }


    public RemainderSortTest() throws IOException, XMLStreamException {
    }

    @Test
    public void sholdBeSortRemainderFromMinToMaxValue() throws IOException, XMLStreamException {
        teller.uploadJsonStreAPI();
        teller.uploadXMLStAX();

        Set<Card> cardsRmndr = new TreeSet<>(new CardRemainderComparator());
        cardsRmndr.addAll(cardOfOwner.getCards());

        Assert.assertEquals(cardsRmndrExpResult, cardsRmndr);

    }
}
