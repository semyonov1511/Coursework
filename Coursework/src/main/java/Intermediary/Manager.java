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
import javax.swing.JLabel;

public class Manager {

    ExcelHandler handler;
    public Calculator calculator;
    Repository repository = new Repository();
    public Manager() {
        calculator = new Calculator();
        handler = new ExcelHandler();
    }

    public void importObjectData(JLabel readingStatusButton) {
        try {
            File file = new File("Вар2_приложение1.xlsx");
            if (!handler.checkFile(file,"Код помещения")){
                throw new Exception();
            }
            repository.setObjectsMap(handler.readObjects(file));
            readingStatusButton.setText("Данные по объекту успешно прочитаны");
        } catch (IOException ex) {
            readingStatusButton.setText("Файла не обнаружено");
        } catch (Exception e) {
            readingStatusButton.setText("Содержимое файла некорректно");
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

    public boolean isWorksRead(){
        return !repository.getWorksList().isEmpty();
    }

    public boolean isObjectsRead(){
        return !repository.getObjectsMap().isEmpty();
    }

    public boolean checkObjectsFile(File file) throws IOException{
        return handler.checkFile(file,"Код помещения");
    }

    public void calculateParameters(){
        calculator.calculate(repository.getObjectsMap());
        //calculator.calculateWithDistribution(repository.getObjectsMap());
    }

    public boolean checkWorksFile(File file) throws IOException {
        return handler.checkFile(file,"Номер");
    }
}
