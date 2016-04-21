package Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Model.Class;
import Model.Hours;

public class ExportToXls implements ExportToXlsxInterface {

    private Map<String, ArrayList<String>> data = new TreeMap<>();
    
    public Map<String, ArrayList<String>> makeBlankWorkbook() {
        
        ArrayList<String> classRoom = new ArrayList<>();
        // Set<String> hours = new TreeSet<>();
        int x=0;
        classRoom.add("Orari");
        for (Class c : Class.values()) {
            classRoom.add(c.getValue());
            x++;
        }

        this.data.put("1", classRoom);
        int i = 2;
        for (Hours h : Hours.values()) {
            ArrayList<String> tmp = new ArrayList<>();
            tmp.add(h.getValue());
            this.data.put(Integer.toString(i), tmp);
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

    public void add(int row, int col, String text) {
        int length = this.data.get(String.valueOf(row)).size();
        if( length>=col){
            this.data.get(String.valueOf(row)).add(col,text);
        }else{
            for(int i = 0; i<col-length; i++){
                this.data.get(String.valueOf(row)).add(" ");
            }
            this.data.get(String.valueOf(row)).add(col,text);
        }
           
       
    }
}
