package Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Model.Days;
import Model.Hours;
import Model.RoomImpl;

public class ExportToXls implements ExportToXlsxInterface {

    private Map<Integer, ArrayList<String>> data = new TreeMap<>();
    // Blank workbook
    XSSFWorkbook workbook = new XSSFWorkbook();

    SaveController controller = new SaveController();
    // Create a sheet
    XSSFSheet sheet = workbook.createSheet("Primo semestre");
    XSSFSheet sheetSecond = workbook.createSheet("Secondo semestre");

    public Map<Integer, ArrayList<String>> makeBlankWorkbook() {

        
        for (Days d : Days.values()) {
            ArrayList<String> classRoom = new ArrayList<>();
            classRoom.add("" + d);
            for (RoomImpl c : controller.getObjToSave().getListRoom()) {
                classRoom.add(c.getNameRoom());
            }

            this.data.put(d.getValue() * classRoom.size(), classRoom);

            int i = d.getValue() * classRoom.size() + 1;
            
            for (Hours h : Hours.values()) {
                ArrayList<String> tmp = new ArrayList<>();
                tmp.add(h.getValue());
                this.data.put(i, tmp);
                i++;
            }
        }
        return this.data;
    }

    public void write(XSSFWorkbook workbook) {
        try {
            // Write the workbook in file system

            FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.home")
                    + System.getProperty("file.separator") + "SiencesSchoolSchedul.xls"));
            workbook.write(out);
            out.close();
            System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
        } catch (Exception e) {
            System.out.println("chiudere il file prima di proseguire");
            e.printStackTrace();
        }

    }

    /*
     * funzione per aggiungere o modificare una cella della tabella
     * 
     * 
     * 
     * 
     */
    public void add(int row, int col, String text) {
        int length = 0;
        length = this.data.get(row).size();
        if (length > col && row > 0 && col > 0) {
            this.data.get(row).set(col, text); // add(col,
                                               // text);
        } else if (row > 0 && col > 0) {
            for (int i = 0; i <= col - length; i++) {
                this.data.get(row).add(" ");
            }
            this.data.get(row).set(col, text);
        }

    }

    public XSSFWorkbook create(XSSFSheet sheet, XSSFWorkbook workbook) {

        // Iterate over data and write to sheet
        int rownum = 0;
        XSSFCellStyle style6 = workbook.createCellStyle();
        XSSFCellStyle style7 = workbook.createCellStyle();
        for (Integer key : this.data.keySet()) {
            // create a row of excelsheet
            Row row = sheet.createRow(rownum);

            // get object array of prerticuler key
            ArrayList<String> objArr = this.data.get(key);

            int cellnum = 0;
            for (String obj : objArr) {
                Cell cell = row.createCell(cellnum);

                if (cellnum == 0 || rownum == 0 || (rownum % this.controller.getObjToSave().getListRoom().size()) == 0) { // per
                                                                         // colorare
                                                                         // diversamente
                                                                         // le
                                                                         // ore
                                                                         // e le
                                                                         // aule
                    style6.setFillBackgroundColor(HSSFColor.GOLD.index);
                    style6.setFillPattern(XSSFCellStyle.LESS_DOTS);
                    // style6.setAlignment(XSSFCellStyle.ALIGN_FILL);
                    sheet.setColumnWidth(cellnum, obj.length() * 400);
                    cell.setCellValue(obj);
                    cell.setCellStyle(style6);
                } else {
                    // style7.setFillBackgroundColor(HSSFColor.AQUA.index);
                    style7.setFillBackgroundColor(HSSFColor.LIGHT_BLUE.index);
                    style7.setFillPattern(XSSFCellStyle.LESS_DOTS); // senza non
                                                                    // fa lo
                                                                    // sfondo
                    // style7.setAlignment(XSSFCellStyle.ALIGN_FILL); // scrive
                    // tre volte
                    sheet.setColumnWidth(cellnum, obj.length() * 400);
                    cell.setCellValue(obj);
                    cell.setCellStyle(style7);
                }
                cellnum++;
            }
            rownum++;
        }
        Map<Integer, ArrayList<String>> data = new TreeMap<>();
        this.data = data;
        return workbook;

    }

    public void addAll(Map<Integer, ArrayList<String>> mapIn, Days day) {
        /*
         * Map<Integer, ArrayList<String>> mapOut = new HashMap<>(); mapOut =
         * mapIn;
         */

        int col = 1;
        for (int row : mapIn.keySet()) {
            for (String s : mapIn.get(row)) {
                this.add(row + day.getValue() * 10, col, s);
                col++;
            }
            col = 1;
        }

    }

    private Map<Days, Map<Integer, ArrayList<String>>> makeMap() {
        Map<Days, Map<Integer, ArrayList<String>>> temp = new HashMap<>();
        for (Reservation res : controller.getObjToSave().getListReservation()) {

        }

        return temp;
    }

    public void save() {

        // make a first period of year
        for (Days d : mapForFirst.keySet()) {
            this.makeBlankWorkbook(d);
            this.addAll(mapForFirst.get(d), d);
        }
        workbook = this.create(sheet, workbook);


        // make a xls file
        this.write(workbook);

    }
}
