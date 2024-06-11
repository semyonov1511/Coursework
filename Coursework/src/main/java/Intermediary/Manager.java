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

    public void importWorksData(File file) {
        try {
            handler.readObjects(new File("Вар2_приложение1.xlsx"));
            repository.setList(handler.readWorks(file));
        } catch (IOException ex) {
        }
    }
}
