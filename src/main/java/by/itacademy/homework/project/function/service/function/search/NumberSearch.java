package by.itacademy.homework.project.function.service.function.search;

import by.itacademy.homework.project.domain.Card;
import by.itacademy.homework.project.domain.CardOfOwner;
import by.itacademy.homework.project.domain.Teller;
import by.itacademy.homework.project.menu.Comand;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class NumberSearch extends Teller implements Comand {

    Logger logger = Logger.getLogger(BankCardValid.class);
    private Scanner in = new Scanner(System.in);

    public NumberSearch(CardOfOwner cardOfOwner) throws IOException, XMLStreamException {
        super(cardOfOwner);
    }

    //SearchingByNumber
    public void execute() {
        cardList.addAll(cardOfOwner.getCards());
        System.out.println("Введите номер банковсеой карты для поиска");
        String cardNumber = in.nextLine();

        for (int i = 0; i < cardList.size(); i++) {
            if (cardList.get(i).getNumber().equals(cardNumber)) {
                System.out.println("----------------------------------------------------------------------------------");
                System.out.println("Карта: " + cardList.get(i));
                System.out.println("----------------------------------------------------------------------------------");
            }
        }
        logger.debug("debug messege");
    }
}

