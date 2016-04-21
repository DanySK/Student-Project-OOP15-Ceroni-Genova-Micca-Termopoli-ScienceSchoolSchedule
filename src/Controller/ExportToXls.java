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

import Model.Class;
import Model.Hours;

public class ExportToXls implements ExportToXlsxInterface {

    private Map<Integer, ArrayList<String>> data = new TreeMap<>();
    // Blank workbook
    XSSFWorkbook workbook = new XSSFWorkbook();
    // Create a sheet
    XSSFSheet sheet = workbook.createSheet("Primo semestre");
    XSSFSheet sheetSecond = workbook.createSheet("Secondo semestre");

    public Map<Integer, ArrayList<String>> makeBlankWorkbook() {
        Map<Integer, ArrayList<String>> data = new TreeMap<>();
        this.data = data;
        ArrayList<String> classRoom = new ArrayList<>();
        // Set<String> hours = new TreeSet<>();
        classRoom.add("Orari");
        for (Class c : Class.values()) {
            classRoom.add(c.getValue());
        }

        this.data.put(0, classRoom);
        int i = 1;
        for (Hours h : Hours.values()) {
            ArrayList<String> tmp = new ArrayList<>();
            tmp.add(h.getValue());
            this.data.put(i, tmp);
            i++;
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
            this.data.get(String.valueOf(row)).set(col, text); // add(col,
                                                               // text);
        } else if (row > 0 && col > 0) {
            for (int i = 0; i <= col - length; i++) {
                this.data.get(row).add(" ");
            }
            this.data.get(row).set(col, text);
        }

    }

    @Override
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

                if (cellnum == 0 || rownum == 0) {
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
        return workbook;
    }

    @Override
    public void addAll(Map<Integer, ArrayList<String>> mapIn) {
        Map<Integer, ArrayList<String>> mapOut = new HashMap<>();
        mapOut = mapIn;

        int col = 1;
        for (int row : mapOut.keySet()) {
            for (String s : mapOut.get(row)) {
                this.add(row, col, s);
                col++;
            }
        }

    }

    @Override
    public void save(Map<Integer, ArrayList<String>> mapForFirst, Map<Integer, ArrayList<String>> mapForSecond) {
        // make a first period of year
        this.makeBlankWorkbook();
        this.addAll(mapForFirst);
        workbook = this.create(sheet, workbook);

        // make a second period of year
        this.makeBlankWorkbook();
        workbook = this.create(sheetSecond, workbook);
        this.addAll(mapForSecond);
        workbook = this.create(sheetSecond, workbook);

        // make a xls file
        this.write(workbook);

    }
}
