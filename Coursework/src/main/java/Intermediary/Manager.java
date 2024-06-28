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

    /**
     * Вызывается при запуске программы, автоматически подгружает файл с объектами.
     *
     * @throws IOException в случае проблем с доступом к файлу.
     *
     * @throws Exception если содержимое файла некорректно.
     * 
     * @param readingStatusLabel - компонент графического интерфейса, в котором отображается статус загрузки файла с объектами.
     */
    public void importObjectData(JLabel readingStatusLabel) {
        try {
            File file = new File("Objects.xlsx");
            if (!handler.checkFile(file,"Код помещения")){
                throw new Exception();
            }
            repository.setObjectsMap(handler.readObjects(file));
            readingStatusLabel.setText("Данные по объекту успешно прочитаны");
        } catch (IOException ex) {
            readingStatusLabel.setText("Файла не обнаружено");
        } catch (Exception e) {
            readingStatusLabel.setText("Содержимое файла некорректно");
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

    /**
     * Привязывает работы к их помещениям с помощью ключей Map'ы комнат и атрибута Room у работ.
     */
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

    public void calculateParameters(){
        calculator.calculate(repository.getObjectsMap());
        calculator.calculateWithDistribution(repository.getObjectsMap());
    }

    public boolean checkWorksFile(File file) throws IOException {
        return handler.checkFile(file,"Номер");
    }
}
