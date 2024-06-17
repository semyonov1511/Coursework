package Intermediary;

import ExcelRelated.ExcelHandler;
import Rooms.Room;
import java.io.File;
import java.io.IOException;
import java.util.Map;

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
    
    public Map<String, Room> getObjects(){
        return repository.getObjectsMap();
    }
}
