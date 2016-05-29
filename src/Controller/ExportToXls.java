package Controller;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Model.Courses;
import Model.Days;
import Model.Hours;
import Model.RoomImpl;

public class ExportToXls implements ExportToXlsxInterface {

    private Map<Integer, ArrayList<String>> data = new TreeMap<>();
    private ControllerWorkers contWork = new ControllerWorkers();
    private String title;
    // Blank workbook
    XSSFWorkbook workbook = new XSSFWorkbook();

    SaveController controller = new SaveController();
    // Create a sheet
    XSSFSheet sheet;

    private void write(XSSFWorkbook workbook) {
        try {
            // Write the workbook in file system

            FileOutputStream out = new FileOutputStream(
                    new File(System.getProperty("user.home") + System.getProperty("file.separator") + title + ".xls"));
            workbook.write(out);
            out.close();
            System.out.println(title + ".xlsx written successfully on disk.");
        } catch (Exception e) {
            System.out.println("chiudere il file prima di proseguire");
            e.printStackTrace();
        }

    }

    private XSSFWorkbook create(XSSFSheet sheet, XSSFWorkbook workbook) {

        // Iterate over data and write to sheet
        int rownum = 0;

        for (Integer key : this.data.keySet()) {
            // create a row of excelsheet
            Row row = sheet.createRow(rownum);

            // get object array of prerticuler key
            ArrayList<String> objArr = this.data.get(key);
            XSSFCellStyle defaul = workbook.createCellStyle(); // le
            // ore
            // e
            int cellnum = 0;
            for (String str : objArr) {
                XSSFColor colorForCourse = new XSSFColor(Color.white); // aule
                for (Courses course : this.contWork.getCoursesFromFile()) {
                    if (course.getName().equals(str)) {
                        colorForCourse = new XSSFColor(course.getType().getColor()); // aule
                    }
                }
                sheet.autoSizeColumn(cellnum);
                Cell cell = row.createCell(cellnum);

                if ( rownum % (this.controller.getObjToSave().getListRoom().size() + 1) == 0  ) { // per   // colorare    // diversamente
                    cell.setCellValue(str);
                    defaul = this.setBorderDefault(defaul);
                    defaul.setFillForegroundColor(new XSSFColor(new Color(3,192,60)));

                    cell.setCellStyle(defaul);
                } else if (cellnum == 0 ) {
                    cell.setCellValue(str);
                    defaul = this.setBorderDefault(defaul);
                    defaul.setFillForegroundColor(new XSSFColor(new Color(255,77,0)));

                    cell.setCellStyle(defaul);
                } else {
                    XSSFCellStyle style = workbook.createCellStyle();
                    cell.setCellValue(str);
                    style = this.setBorder(style);
                    style.setFillForegroundColor(colorForCourse);
                    style.setAlignment(XSSFCellStyle.SOLID_FOREGROUND);

                    cell.setCellStyle(style);

                }
                // sheet.set

                cellnum++;
            }
            rownum++;
        }
        return workbook;

    }

    private XSSFCellStyle setBorderDefault(XSSFCellStyle style) {
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);

        return style;
    }

    private XSSFCellStyle setBorder(XSSFCellStyle style) {
        style.setBorderBottom(HSSFCellStyle.BORDER_DOTTED);
        style.setBorderLeft(HSSFCellStyle.BORDER_DOTTED);
        style.setBorderRight(HSSFCellStyle.BORDER_DOTTED);
        style.setBorderTop(HSSFCellStyle.BORDER_DOTTED);
        style.setFillPattern(XSSFCellStyle.BORDER_DOTTED);

        return style;
    }

    private Map<Integer, ArrayList<String>> makeMap() {
        Map<Integer, ArrayList<String>> temp = new HashMap<>();

        Integer i = 0;

        for (Days d : Days.values()) {
            ArrayList<String> hoursArray = new ArrayList<String>();

            hoursArray.add(d.getString());
            for (Hours col : Hours.values()) {// scorro le ore e creo una lista
                                              // come intestazione
                hoursArray.add(col.getValue());
            }
            temp.put(i++, hoursArray); // inserisco la prima riga della tabella

            for (RoomImpl room : controller.getObjToSave().getListRoom()) { // scorro
                                                                            // la
                                                                            // lista
                                                                            // delle
                                                                            // stanze

                ArrayList<String> array = new ArrayList<>();
                for (@SuppressWarnings("unused")
                Hours h : Hours.values()) {
                    array.add(" ");
                }
                array.add(0, room.getNameRoom());
                for (Reservation res : contWork.getByDay(d)) {
                    if (res.getRoom().getNameRoom().equals(room.getNameRoom())) {
                        array.set(hoursArray.indexOf(res.getHour().getValue()), res.getCourse().getName());
                    }
                }
                temp.put(i++, array);
            }
        }
        return temp;
    }

    public void save(String period) {
        this.title = period;
        this.data = this.makeMap();

        this.sheet = workbook.createSheet(period);

        workbook = this.create(sheet, workbook);

        // make a xls file
        this.write(workbook);

    }
}
