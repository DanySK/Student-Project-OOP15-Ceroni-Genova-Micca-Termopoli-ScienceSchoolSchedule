package Controller;

import java.util.ArrayList;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Model.Days;

public interface ExportToXlsxInterface {

    public Map<Integer, ArrayList<String>> makeBlankWorkbook();

    public void write(XSSFWorkbook workbook);

    public XSSFWorkbook create(XSSFSheet sheet, XSSFWorkbook workbook);

    public void add(int row, int col, String text);

    public void addAll(Map<Integer, ArrayList<String>> map,Days day);

    public void save();

}
