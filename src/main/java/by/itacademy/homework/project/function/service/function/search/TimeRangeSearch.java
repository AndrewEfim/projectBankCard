package by.itacademy.homework.project.function.service.function.search;

import by.itacademy.homework.project.domain.CardOfOwner;
import by.itacademy.homework.project.domain.Teller;
import by.itacademy.homework.project.menu.Comand;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class TimeRangeSearch extends Teller implements Comand {
    private Scanner in = new Scanner(System.in);

    public TimeRangeSearch(CardOfOwner cardOfOwner) throws IOException, XMLStreamException {
        super(cardOfOwner);
    }

    //SearchingTimeRangeCard
    public void execute() {
        cardList.addAll(cardOfOwner.getCards());
        System.out.println("Введите начоло диапазона в формате yyyy-MM-dd");
        LocalDate startRange = LocalDate.parse(in.nextLine());
        System.out.println(startRange);
        System.out.println("Введите конец диапазона в формате yyyy-MM-dd");
        LocalDate endRange = LocalDate.parse(in.nextLine());
        System.out.println(endRange);
        for (int i = 0; i < cardList.size(); i++) {
            if ((startRange.isBefore(cardList.get(i).getYear())) && ((endRange).isAfter(cardList.get(i).getYear()))) {
                System.out.println("----------------------------------------------------------------------------------");
                System.out.println("Результат поиска по временному диапазону: " + cardList.get(i));
                System.out.println("----------------------------------------------------------------------------------");
                System.out.println("В веденном диапазоне карт не нейденно");
            }
        }
    }
}
