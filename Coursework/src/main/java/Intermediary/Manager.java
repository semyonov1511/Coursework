package Intermediary;

import ExcelRelated.ExcelHandler;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Manager {

    ExcelHandler handler;

    public Manager() {
        handler = new ExcelHandler();
    }

    public void importWorksData(File file) {
        try {
            handler.readExcel(file);
        } catch (IOException ex) {
        }
    }
}
