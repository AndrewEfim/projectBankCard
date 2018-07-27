package by.itacademy.homework.project.function.service.read;

import by.itacademy.homework.project.domain.Card;

import java.io.IOException;
import java.util.Set;

public interface CardsRead {
    Set<Card> execute() throws IOException;
}
