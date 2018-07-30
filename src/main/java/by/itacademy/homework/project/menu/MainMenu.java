package by.itacademy.homework.project.menu;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.Scanner;

public class MainMenu {
    private Scanner inputcomand = new Scanner(System.in);
    private Menu menu = new Menu();

    public MainMenu() throws IOException, XMLStreamException {
    }

    public void Start() {
        boolean f = true;
        while (f) {
            menu.textMenu();
            try {
            int cmd = Integer.parseInt(inputcomand.nextLine());
            if (cmd == 7) {
                f = false;
                break;
            }
            if(cmd > 7)throw new WrongCommandException("Такой функции меню не существует");
            Comand comand = menu.getComand(cmd);
            comand.execute();
            } catch (WrongCommandException e) {
                e.printStackTrace();
            }
        }
    }
}
