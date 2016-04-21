package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WorkWithXlsx {

    private static ExportToXlsxInterface model = new ExportToXls();

    public static void main(String[] args) {
        // Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        // Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Science School Schedul");
       
        Map<String, ArrayList<String>> data = new HashMap<>();
        data.putAll(model.makeBlankWorkbook());

        model.add(3, 5, "ciao sono massi");
        // Iterate over data and write to sheet
        Set<String> keyset = data.keySet();

        int rownum = 0;
        for (String key : keyset) {
            // create a row of excelsheet
            Row row = sheet.createRow(rownum++);

            // get object array of prerticuler key
            ArrayList<String> objArr = data.get(key);

            int cellnum = 0;

            for (String obj : objArr) {

                Cell cell = row.createCell(cellnum);
                XSSFCellStyle style6 = workbook.createCellStyle();
                if (cellnum == 1) {
                    cell.setCellValue(obj);
                    style6.setFillBackgroundColor(HSSFColor.GOLD.index);
                    sheet.setColumnWidth(cellnum, obj.length() * 400);
                    cell.setCellValue(obj);
                    cell.setCellStyle(style6);
                } else {
                    style6.setFillBackgroundColor(HSSFColor.AQUA.index);
                    // style6.setFillBackgroundColor(HSSFColor.LIGHT_BLUE.index);
                    // style6.setFillPattern(XSSFCellStyle.LESS_DOTS);
                    // style6.setAlignment(XSSFCellStyle.ALIGN_FILL);
                    sheet.setColumnWidth(cellnum, obj.length() * 400);
                    cell.setCellValue(obj);
                    cell.setCellStyle(style6);

                }
                cellnum++;

            }
        }
       
        model.save(workbook);

    }
}
