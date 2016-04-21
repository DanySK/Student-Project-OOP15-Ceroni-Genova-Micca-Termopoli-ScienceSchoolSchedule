package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WorkWithXlsx {

    private static ExportToXlsxInterface model = new ExportToXls();

    public static void main(String[] args) {

        ArrayList<String> string = new ArrayList<>();
        for (int y = 0; y < 10; y++) {
            string.add(Integer.toString(y));
        }
        Map<Integer, ArrayList<String>> tmp = new HashMap<>();
        tmp.put(1, string);
        model.save(tmp, tmp);

    }
}
