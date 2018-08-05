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
    private Scanner in = new Scanner(System.in);
    private Teller teller;

    public BankCardValid(CardOfOwner cardOfOwner, List<Card> cardList) throws IOException, XMLStreamException {
        super(cardOfOwner, cardList);
    }


    //SearchingValidTimeCard
    public void execute() {
        System.out.println(cardList.size());
        System.out.println("Введите ID карты");
        int id = Integer.parseInt(in.nextLine());
        Period period = null;
        LocalDate now = LocalDate.now();
        for (int i = 0; i < cardList.size(); i++) {
            if (cardList.get(i).getId() == id) {
                period = Period.between(now, cardList.get(i).getYear());

                if((period.getDays()>=0)&&(period.getMonths()>=0)&&(period.getYears()>=0)){
                    System.out.println("----------------------------------------------------------------------------------");
                    System.out.println("Карта банка : " + cardList.get(i).getName()
                            + " " + "Карта валидна еще: " + period.getYears() + "год(-а) "
                            + period.getMonths() + "месяц(-а) " + period.getDays() + "день(-я)");
                    System.out.println("----------------------------------------------------------------------------------");
                }
                else  //if ((period.getDays()<0)&&(period.getMonths()<0)&&(period.getYears()<0))
                     {
                    System.out.println("Карта c номером: " +" "+ getCardList().get(i).getNumber()+" "+" не дествительна " );
                }
            }
        }
        logger.debug("debug SearchingValidTimeCard");
    }
}
