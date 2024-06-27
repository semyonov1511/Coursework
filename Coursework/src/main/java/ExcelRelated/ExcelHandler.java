package ExcelRelated;

import Intermediary.Setter;
import Rooms.Room;
import Works.Work;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelHandler {

    Setter setter = new Setter();

    public ArrayList<Work> readWorks(File file) throws FileNotFoundException, IOException {
        int i = 0;
        ArrayList<Work> list = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(file); Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (i == 1) {
                    list.add(setter.setWorkParameters(row));
                }
                switch (row.getCell(0).getCellType()) {
                    case STRING:
                        i = 1;
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Map<String, Room> readObjects(File file) throws FileNotFoundException, IOException {
        Map<String, Map<String, Object>> data = new HashMap<>();

        Map<String, Room> roomsMap = new HashMap<>();

        try (FileInputStream fileInputStream = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {

            Sheet sheet = workbook.getSheetAt(0); // выбираем первый лист

            int rowIndex = 5; // начинаем с 6-й строки
            while (true) {
                Row row = sheet.getRow(rowIndex);
                if (row == null) {
                    break; // если строка пустая, то выходим из цикла
                }
                setter.setRow(row);
                Room room = setter.setRooms();
                roomsMap.put(room.getName(), room);
                rowIndex++;
            }
        }
        return (roomsMap);
    }

    public boolean checkFile(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        if (!isXlsxFile(file)) { return false; }
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        return (row.getCell(0).getStringCellValue().equals("Номер"));
    }

    public static boolean isXlsxFile(File file) {
        if (!file.isFile()) {
            return false;
        }

        String fileName = file.getName();
        String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);

        return fileExtension.equalsIgnoreCase("xlsx");
    }
}
