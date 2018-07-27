package by.itacademy.homework.project;

import by.itacademy.homework.project.menu.MainMenu;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;


public class App {
    static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) throws IOException, XMLStreamException {
        logger.debug("debug App.class");
        MainMenu mainMenu = new MainMenu();
        mainMenu.Start();
    }
}


