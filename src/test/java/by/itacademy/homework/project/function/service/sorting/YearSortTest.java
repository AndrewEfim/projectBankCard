package by.itacademy.homework.project.function.service.sorting;

import by.itacademy.homework.project.domain.Card;
import by.itacademy.homework.project.domain.CardOfOwner;
import by.itacademy.homework.project.domain.Teller;
import by.itacademy.homework.project.function.service.function.sorting.CardYearComparator;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class YearSortTest {
    private CardOfOwner cardOfOwner = new CardOfOwner();
    private List<Card> cardList = new ArrayList<>();
    private Set<Card> cardsYear = null;
    private Set<Card> cardsYearExpResult = new TreeSet<>(new CardYearComparator<>());
    private Teller teller = new Teller(cardOfOwner,cardList);


    {
        cardsYearExpResult.add(new Card(4, "BPS Sber Bank", "2299 3565 2565 9776", LocalDate.of(2016, 01, 23), "10", false));
        cardsYearExpResult.add(new Card(5, "Idea Bank", "2569 5662 2565 5697", LocalDate.of(2019, 01, 25), "50", true));
        cardsYearExpResult.add(new Card(2, "Belarus Bank", "2231 3266 2356 9655", LocalDate.of(2019, 07, 25), "1000", true));
        cardsYearExpResult.add(new Card(0, "BSB Bank", "2232 3265 2356 9656", LocalDate.of(2019, 9, 25), "2000", true));
        cardsYearExpResult.add(new Card(3, "Alpha Bank", "2232 3265 6565 5696", LocalDate.of(2020, 06, 01), "100", true));
        cardsYearExpResult.add(new Card(1, "Moskva_Minsk Bank", "2212 3265 2356 9126", LocalDate.of(2021, 9, 01), "500", true));
        cardsYearExpResult.add(new Card(4, "BPS Sber Bank", "2299 3565 2565 9776", LocalDate.of(2022, 01, 23), "10", false));
    }

    public YearSortTest() throws IOException, XMLStreamException {
    }

    @Test
    public void shouldBeSortYearFromMinToMax() throws IOException, XMLStreamException {
        teller.uploadJsonStreAPI();
        teller.uploadXMLStAX();
        Set<Card> cardsYear = new TreeSet<>(new CardYearComparator<>());
        cardsYear.addAll(cardOfOwner.getCards());
        Assert.assertEquals(cardsYearExpResult, cardsYear);
    }
}
