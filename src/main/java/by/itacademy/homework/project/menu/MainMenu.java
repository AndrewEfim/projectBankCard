package by.itacademy.homework.project.menu;

import sun.applet.Main;

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
            int cmd = Integer.parseInt(inputcomand.nextLine());
            if (cmd == 7) {
                f = false;
                break;
            }
            Comand comand = menu.getComand(cmd);
            comand.execute();
        }
    }
}
