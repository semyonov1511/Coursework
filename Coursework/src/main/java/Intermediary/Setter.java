package Intermediary;

import Rooms.Room;
import Works.Work;
import org.apache.poi.ss.usermodel.Row;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Setter {

    Row row;
    Room room;

    public void setRow(Row row){
        this.row = row;
    }

    public Room setRooms(){
        this.room = new Room();
        room.addFloor();
        room.addWalls();
        room.addCeiling();
        setRoomParameters();
        setFloorParameters();
        setWallsParameters();
        setCeilingParameters();
        return room;
    }

    private void setRoomParameters (){
        if (row.getCell(1).getStringCellValue().equals("Ингаляционная")) {
            switch (row.getCell(2).getStringCellValue()) {
                case "Этаж 2" -> room.setName("Ингаляционная 2-й этаж");
                case "Этаж 1" -> room.setName("Ингаляционная 1-й этаж");
                default -> room.setName("Комната");
            }
        } else {
            room.setName(row.getCell(1).getStringCellValue());
        }
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(row.getCell(2).getStringCellValue());
        if (matcher.find()) {
            room.setStorey(Integer.parseInt(matcher.group()));
        }

        room.setLength(row.getCell(3).getNumericCellValue());
        room.setWidth(row.getCell(4).getNumericCellValue());
        room.setHeight(row.getCell(5).getNumericCellValue());
        room.setArea(row.getCell(6).getNumericCellValue());
        room.setVolume(row.getCell(7).getNumericCellValue());
        room.setRadiationPower(row.getCell(24).getNumericCellValue());
        room.setRadiationActivity(row.getCell(25).getNumericCellValue());
    }
    private void setFloorParameters(){
        room.getFloor().setThickness(row.getCell(9).getNumericCellValue());
        room.getFloor().setCoatingMaterial(row.getCell(12).getStringCellValue());
        room.getFloor().setCoverageArea(row.getCell(13).getNumericCellValue());
        room.getFloor().setContaminationArea(row.getCell(18).getNumericCellValue());
        room.getFloor().setContaminationDepth(row.getCell(19).getNumericCellValue());
    }

    private void setWallsParameters(){
        room.getWalls().setThickness(row.getCell(8).getNumericCellValue());
        room.getWalls().setCoatingMaterial(row.getCell(14).getStringCellValue());
        room.getWalls().setCoverageArea(row.getCell(15).getNumericCellValue());
        room.getWalls().setContaminationArea(row.getCell(20).getNumericCellValue());
        room.getWalls().setContaminationDepth(row.getCell(21).getNumericCellValue());
    }

    private void setCeilingParameters(){
        room.getCeiling().setCoatingMaterial(row.getCell(16).getStringCellValue());
        room.getCeiling().setCoverageArea(row.getCell(17).getNumericCellValue());
        room.getCeiling().setContaminationArea(row.getCell(22).getNumericCellValue());
        room.getCeiling().setContaminationDepth(row.getCell(23).getNumericCellValue());
    }

    public Work setWorkParameters() {
        Work work = new Work();
        work.setRoom(row.getCell(2).getStringCellValue());
        work.setPart(row.getCell(3).getStringCellValue());
        work.setName(row.getCell(5).getStringCellValue());
        work.setType(row.getCell(7).getStringCellValue());
        work.setPrice((int) row.getCell(8).getNumericCellValue());
        work.setStandartTime((int) row.getCell(10).getNumericCellValue());
        work.setWorkersQuantity((int) row.getCell(11).getNumericCellValue());
        return work;
    }

}
