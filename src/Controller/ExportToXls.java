package Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Model.Class;
import Model.Hours;

public class ExportToXls implements ExportToXlsxInterface {

    public Map<String, Set<String>> makeBlankWorkbook() {
        Map<String, Set<String>> data = new TreeMap<>();
        Set<String> classRoom = new TreeSet<>();
        // Set<String> hours = new TreeSet<>();
        for (Class c : Class.values()) {
            classRoom.add(c.getValue());
        }

        data.put("1", classRoom);
        int i = 2;
        for (Hours h : Hours.values()) {
            Set<String> tmp = new HashSet<>();
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
                    + System.getProperty("file.separator") + "SiencesSchoolSchedul.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
