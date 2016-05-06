package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Model.Days;
import Model.Professor;

public class WorkWithXlsx {

    private static ObjWorkersInterface model = new ObjWorkers();
    private static ProfessorControllerInterface profContr = new ProfessorController();
    private static ExportToXlsxInterface modelxls;

    public static void main(String[] args) {

        

        // per testare la scrittura e salvataggio da file
        Set<ObjToSave> obj = new HashSet<>();
        Set<ObjToSave> obj1 = new HashSet<>();
        obj = model.createNewEmptyList();
        model.save(obj);
        obj1 = model.openFile();
        System.out.println("2°" + obj1);

        int i = 1;
        for (ObjToSave ob1 : obj1) {
            System.out.println(i + " " + ob1.toString());
            i++;
        }
        //prova con prof
        Set<Professor> objP = new HashSet<>();
        Set<Professor> obj1P = new HashSet<>();
        objP = profContr.createNewEmptyList();
        profContr.save(objP);
        obj1P = profContr.openFile();
        System.out.println("2°" + obj1P);

        int x = 1;
        for (Professor ob1 : obj1P) {
            System.out.println(x + " " + ob1.toString());
            x++;
        }
        
        
        
      //for export in xls type
       /* ArrayList<String> string = new ArrayList<>();
        for (int y = 0; y < 10; y++) {
            string.add(Integer.toString(y));
        }
        Map<Integer, ArrayList<String>> tmp = new HashMap<>();
        tmp.put(1, string);
        tmp.put(2, string);
        tmp.put(3, string);
        tmp.put(4, string);
        Map<Days, Map<Integer, ArrayList<String>>> finalMap = new HashMap<>();
        for (Days d : Days.values()) {
            finalMap.put(d, tmp);
        }

        modelxls.save(finalMap, finalMap);
        System.out.println(finalMap);*/
        
    }
}
