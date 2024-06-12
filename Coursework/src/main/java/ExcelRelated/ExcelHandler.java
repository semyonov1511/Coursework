package ExcelRelated;

import Works.Work;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelHandler {

    public ArrayList<Work> readWorks(File file) throws FileNotFoundException, IOException {
        int i = 0;
        HashMap<String, ArrayList<Work>> passportsAndNames = new HashMap<>();
        ArrayList<Work> list = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(file); Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (i==1) {
                    list.add(setParameters(row));
                }
                switch (row.getCell(0).getCellType()) {
                    case STRING:
                        i=1;
                        break;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Map<String, Map<String, Object>> readObjects(File file) throws FileNotFoundException, IOException{
        Map<String, Map<String, Object>> data = new HashMap<>();

        try (FileInputStream fileInputStream = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {

            Sheet sheet = workbook.getSheetAt(0); // выбираем первый лист

            int rowIndex = 5; // начинаем с 6-й строки
            while (true) {
                Row row = sheet.getRow(rowIndex);
                if (row == null) {
                    break; // если строка пустая, то выходим из цикла
                }
                Map<String, Object> rowData = new HashMap<>();
                rowData = setObjectsMap(rowData,row);
                data.put(row.getCell(1).getStringCellValue(), rowData); // ключ в формате "rowX"
                rowIndex++;
            }
        }
        System.out.println(data);
        return (data);
    }

    private Map<String, Object> setObjectsMap(Map<String, Object> map, Row row){

        map.put("Расположение",row.getCell(2).getStringCellValue());

        map.put("Длина",row.getCell(3).getNumericCellValue());
        map.put("Ширина",row.getCell(4).getNumericCellValue());
        map.put("Высота",row.getCell(5).getNumericCellValue());
        map.put("Площадь",row.getCell(6).getNumericCellValue());
        map.put("Объем",row.getCell(7).getNumericCellValue());
        map.put("Толщина стен",row.getCell(8).getNumericCellValue());
        map.put("Толщина пола",row.getCell(9).getNumericCellValue());

        map.put("Материал покрытия пола",row.getCell(12).getStringCellValue());
        map.put("Площадь покрытия пола",row.getCell(13).getNumericCellValue());
        map.put("Материал покрытия стен",row.getCell(14).getStringCellValue());
        map.put("Площадь покрытия стен",row.getCell(15).getNumericCellValue());
        map.put("Материал покрытия потолка",row.getCell(16).getStringCellValue());
        map.put("Площадь покрытия потолка",row.getCell(17).getNumericCellValue());

        map.put("Площадь загрязнения пола",row.getCell(18).getNumericCellValue());
        map.put("Глубина загрязнения пола",row.getCell(19).getNumericCellValue());
        map.put("Площадь загрязнения стен",row.getCell(20).getNumericCellValue());
        map.put("Глубина загрязнения стен",row.getCell(21).getNumericCellValue());
        map.put("Площадь загрязнения потолка",row.getCell(22).getNumericCellValue());
        map.put("Глубина загрязнения потолка",row.getCell(23).getNumericCellValue());

        map.put("Мощность дозы излучения",row.getCell(24).getNumericCellValue());
        map.put("Объемная активность излучения",row.getCell(25).getNumericCellValue());

        return map;
    }
    
    private Work setParameters(Row row){
        Work work = new Work();
        work.setRoom(row.getCell(2).getStringCellValue());
        work.setName(row.getCell(5).getStringCellValue());
        work.setType(row.getCell(7).getStringCellValue());
        work.setPrice((int)row.getCell(8).getNumericCellValue());
        work.setStandartTime((int)row.getCell(10).getNumericCellValue());
        work.setWorkersQuantity((int)row.getCell(11).getNumericCellValue());
        return work;
    }
}
