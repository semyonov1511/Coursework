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
            repository.setList(handler.readExcel(file));
        } catch (IOException ex) {
        }
    }
}
