package by.itacademy.homework.project.domain;

import java.time.LocalDate;

public class Card {

    private int id;
    private String name;
    private String number;
    private LocalDate year;
    private String remainder;
    private boolean available;

    public Card(int id, String name, String number, LocalDate year, String remainder, boolean available) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.year = year;
        this.remainder = remainder;
        this.available = available;
    }

    public Card(int id, String name, String number, LocalDate year, String remainder, String avaliable) {
        this(id, name, number, year, remainder, Boolean.getBoolean(avaliable));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (id != card.id) return false;
        if (!name.equals(card.name)) return false;
        if (!number.equals(card.number)) return false;
        if (!year.equals(card.year)) return false;
        return remainder.equals(card.remainder);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + number.hashCode();
        result = 31 * result + year.hashCode();
        result = 31 * result + remainder.hashCode();
        return result;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public LocalDate getYear() {
        return year;
    }

    public String getRemainder() {
        return remainder;
    }

    public boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", year=" + year +
                ", remainder=" + remainder +
                ", avaliable=" + available +
                '}';
    }

}
