package Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Model.Class;
import Model.Hours;

public class ExportToXls implements ExportToXlsxInterface {

    public Map<String, ArrayList<String>> makeBlankWorkbook() {
        Map<String, ArrayList<String>> data = new TreeMap<>();
        ArrayList<String> classRoom = new ArrayList<>();
        // Set<String> hours = new TreeSet<>();
        classRoom.add("Orari");
        for (Class c : Class.values()) {
            classRoom.add(c.getValue());
        }

        data.put("1", classRoom);
        int i = 2;
        for (Hours h : Hours.values()) {
            ArrayList<String> tmp = new ArrayList<>();
            tmp.add(h.getValue());
            data.put(Integer.toString(i), tmp);
            i++;
        }
        return data;
    }

    public void save(XSSFWorkbook workbook) {
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
}
