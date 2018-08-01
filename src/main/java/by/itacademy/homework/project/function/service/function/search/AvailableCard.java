package by.itacademy.homework.project.function.service.function.search;

import by.itacademy.homework.project.domain.CardOfOwner;
import by.itacademy.homework.project.domain.Teller;
import by.itacademy.homework.project.menu.Comand;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.Scanner;

public class AvailableCard extends Teller implements Comand {
    Logger logger = Logger.getLogger(AvailableCard.class);
    private Scanner in = new Scanner(System.in);

    public AvailableCard(CardOfOwner cardOfOwner) throws IOException, XMLStreamException {
        super(cardOfOwner);
    }

    //cardAvailable
    public void execute() {
        cardList.addAll(cardOfOwner.getCards());
        System.out.println("Введите название банка");
        String BankName = in.nextLine();
        double countBankCard = 0;
        double numberOfCardIssuedId0 = 0;
        for (int i = 0; i < cardList.size(); i++) {
            if (cardList.get(i).getName().equals(BankName)) {
                countBankCard++;
                numberOfCardIssuedId0 = (countBankCard / cardList.size()) * 100;
                System.out.println("------------------------------------------------------------------------------------------------------");
                System.out.println("Количество карт банка " + cardList.get(i).getName()
                        + " " + countBankCard + " "
                        + " " + "Прецент от общего числа " + " "
                        + numberOfCardIssuedId0 + " " + "%");
                System.out.println("------------------------------------------------------------------------------------------------------");
            }
        }
        logger.debug("debug numbersOfBankCard");
    }
}
