package Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WorkWithXlsx {

    private static ExportToXlsxInterface model = new ExportToXls();

    public static void main(String[] args) {
        // Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        // Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Science School Schedul");

        Map<String, Set<String>> data = new HashMap<>();
        data.putAll(model.makeBlankWorkbook());

        // Iterate over data and write to sheet
        Set<String> keyset = data.keySet();

        int rownum = 0;
        for (String key : keyset) {
            // create a row of excelsheet
            Row row = sheet.createRow(rownum++);

            // get object array of prerticuler key
            Set<String> objArr = data.get(key);

            int cellnum = 0;

            for (String obj : objArr) {
                Cell cell = row.createCell(cellnum++);

                cell.setCellValue((String) obj);

            }
        }
        model.save(workbook);
        // This data needs to be written (Object[])
        /*
         * Map<String, Object[]> data = new TreeMap<String, Object[]>();
         * 
         * data.put("1", new Object[] { "Fascie Orarie", "Aula Magna", "Aula A",
         * "Aula B", "Aula C", "Aula D", "Aula a" }); int i = 2; for (Hours h :
         * Hours.values()) { data.put(Integer.toString(i), new Object[] {
         * h.getValue() }); i++; }
         */

        /*
         * data.put("3", new Object[]{2, "Lokesh", "Gupta"}); data.put("4", new
         * Object[]{3, "John", "Adwards"}); data.put("5", new Object[]{4,
         * "Brian", "Schultz"});
         */

    }
}
