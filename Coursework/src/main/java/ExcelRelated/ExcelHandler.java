package ExcelRelated;

import Entities.Work;
import java.io.*;
import java.util.ArrayList;

import Intermediary.Repository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelHandler {

    public ArrayList<Work> readExcel(File file) throws FileNotFoundException, IOException {
        int i = 0;
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
