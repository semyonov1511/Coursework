package Intermediary;

import Calculator.Calculator;
import ExcelRelated.ExcelHandler;
import Rooms.Room;
import Works.Work;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class Manager {

    ExcelHandler handler;
    Calculator calculator;
    Repository repository = new Repository();
    public Manager() {
        calculator = new Calculator();
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
            repository.setWorksList(handler.readWorks(file));
        } catch (IOException ex) {
        }
    }
    
    public Map<String, Room> getObjects(){
        return repository.getObjectsMap();
    }

    public void connectObjectsWorks(){
        for (String key : getObjects().keySet()) {
            ArrayList<Work> filteredWorks = (ArrayList<Work>) repository.getWorksList().stream()
                    .filter(work -> work.getRoom().equals(key))
                    .collect(Collectors.toList());
            for (Work work : filteredWorks){
                repository.getObjectsMap().get(key).addWork(work);
            }
        }

    }

    public void calculateParameters(){
        calculator.setMap(repository.getObjectsMap());
        calculator.calculate();
    }
}
