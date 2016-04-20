package Controller;

import java.util.Map;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public interface ExportToXlsxInterface {

    public Map<String, Set<String>> makeBlankWorkbook();

    public void save(XSSFWorkbook workbook);

}
