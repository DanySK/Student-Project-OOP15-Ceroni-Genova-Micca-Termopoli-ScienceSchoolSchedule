package Controller;

import java.util.ArrayList;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public interface ExportToXlsxInterface {

    public Map<String, ArrayList<String>> makeBlankWorkbook();

    public void save(XSSFWorkbook workbook);
    
    public void add(int row, int col, String text);
    

}
