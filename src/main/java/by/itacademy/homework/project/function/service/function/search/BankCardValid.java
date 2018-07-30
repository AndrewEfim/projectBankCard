package by.itacademy.homework.project.function.service.function.search;

import by.itacademy.homework.project.domain.Card;
import by.itacademy.homework.project.domain.CardOfOwner;
import by.itacademy.homework.project.domain.Teller;
import by.itacademy.homework.project.menu.Comand;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class BankCardValid extends Teller implements Comand {
    Logger logger = Logger.getLogger(BankCardValid.class);
    //private List<Card> cardList = new ArrayList<>();
    private Scanner in = new Scanner(System.in);

    public BankCardValid(CardOfOwner cardOfOwner) throws IOException, XMLStreamException {
        super(cardOfOwner);
    }

    //SearchingValidTimeCard
    public void execute() {
        cardList.addAll(cardOfOwner.getCards());
        System.out.println("Введите ID карты");
        int id = Integer.parseInt(in.nextLine());
        int index = 0;
        boolean found = false;
        Period period = null;
        LocalDate now = LocalDate.now();
        for (int i = 0; i < cardList.size(); i++) {
            if (cardList.get(i).getId() == id) {
                period = Period.between(now, cardList.get(i).getYear());
                index = i;
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("Карта банка : " + cardList.get(index).getName()
                    + " " + "Карта валидна еще: " + period.getYears() + "год(-а) "
                    + period.getMonths() + "месяц(-а) " + period.getDays() + "день(-я)");
            System.out.println("----------------------------------------------------------------------------------");
        } else {
            System.out.println("Банковский карты с таким id нет");
        }
        logger.debug("debug SearchingValidTimeCard");
    }
}
