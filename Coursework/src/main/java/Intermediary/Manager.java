package Intermediary;

import ExcelRelated.ExcelHandler;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Manager {

    ExcelHandler handler;
    Repository repository = new Repository();
    public Manager() {
        handler = new ExcelHandler();
    }

    public void importObjectData() {
        try {
            repository.setObjectsMap(handler.readObjects(new File("Вар2_приложение1.xlsx")));

        } catch (IOException ex) {
        }
    }
    public void importWorksData(File file) {
        try {
            importObjectData();
            repository.setWorksList(handler.readWorks(file));
        } catch (IOException ex) {
        }
    }
}
