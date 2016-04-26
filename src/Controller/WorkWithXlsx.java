package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Model.Days;

public class WorkWithXlsx {

    private static ExportToXlsxInterface model = new ExportToXls();

    public static void main(String[] args) {

        ArrayList<String> string = new ArrayList<>();
        for (int y = 0; y < 10; y++) {
            string.add(Integer.toString(y));
        }
        Map<Integer, ArrayList<String>> tmp = new HashMap<>();
        tmp.put(1, string);
        tmp.put(2, string);
        tmp.put(3, string);
        tmp.put(4, string);
        Map<Days,Map<Integer, ArrayList<String>>> finalMap = new HashMap<>();
        for (Days d : Days.values()) {
            finalMap.put(d, tmp);
        }
       
        model.save(finalMap,finalMap);
        System.out.println(finalMap);

    }
}
