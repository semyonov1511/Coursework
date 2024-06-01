package ExcelRelated;

import Entities.Work;
import java.io.*;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelHandler {

    public void readExcel(File file) throws FileNotFoundException, IOException {
        ArrayList<Work> list = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(file); Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                setParameters(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void setParameters(Row row){
        Work work = new Work();
        work.setRoom(row.getCell(2).getStringCellValue());
        System.out.println("бебе "+work.getRoom());
    }
}
