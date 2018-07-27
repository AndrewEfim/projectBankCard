package by.itacademy.homework.project.function.service.read;

import by.itacademy.homework.project.domain.Card;
import by.itacademy.homework.project.domain.CardOfOwner;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class ReadRemoteFileStreAPI {

    URL link = new URL("https://raw.githubusercontent.com/AndrewEfim/finalProject/master/BankCard.json");
    URLConnection connection = link.openConnection();
    InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
    JsonFactory jFactory = new JsonFactory();
    JsonParser jsonParser = jFactory.createParser(link);
    JsonParser jParser = jFactory.createParser(connection.getInputStream());
    private CardOfOwner cardOfOwner;
    private Set<Card> cards = new HashSet<>();
    Integer parseId;
    String parseName;
    String parseNumber;
    LocalDate parseYear;
    String parseRemainder;
    Boolean parseAvaliable;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public ReadRemoteFileStreAPI() throws IOException {
        this.cards = cards;
    }

    public Set<Card> execute() throws IOException {
        while (jParser.nextToken() != JsonToken.END_ARRAY) {
            while (jParser.nextToken() != JsonToken.END_OBJECT) {
                String fildname = jParser.getCurrentName();

                if ("id".equals(fildname)) {
                    jParser.nextToken();
                    parseId = jParser.getIntValue();
                    //System.out.println(parseId);
                }
                if ("name".equals(fildname)) {
                    jParser.nextToken();
                    parseName = jParser.getText();
                    //System.out.println(parseName);
                }
                if ("number".equals(fildname)) {
                    jParser.nextToken();
                    parseNumber = jParser.getText();
                    //System.out.println(parseNumber);
                }
                if ("year".equals(fildname)) {
                    jParser.nextToken();
                    parseYear = LocalDate.parse(jParser.getText(), formatter);
                    //System.out.println(parseYear);
                }
                if ("remainder".equals(fildname)) {
                    jParser.nextToken();
                    parseRemainder = jParser.getText();
                    //System.out.println(parseRemainder);
                }

                if ("available".equals(fildname)) {
                    jParser.nextToken();
                    parseAvaliable = jParser.getBooleanValue();
                    // System.out.println(parseAvaliable);
                }
            }
            cards.add(new Card( parseId, parseName, parseNumber, parseYear, parseRemainder, parseAvaliable));
        }
        if (jParser.nextToken() == JsonToken.END_OBJECT) {
            this.cards.add(new Card(parseId, parseName, parseNumber, parseYear, parseRemainder, parseAvaliable));
           // System.out.println(cards.size());
        }
        return cards;
    }

    public Set<Card> getCards() {
        return cards;
    }
}