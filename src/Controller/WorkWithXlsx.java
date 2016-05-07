package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.CoursesImpl;
import Model.ListProfessor;
import Model.Professor;
import Model.Type;

public class WorkWithXlsx {
    private static ProfessorControllerInterface profContr = new ProfessorController();
    private static ExportToXlsxInterface modelxls;

    public static void main(String[] args) {

        // prova con prof
        List<List<Object>> lista = new ArrayList<>();
        List<Object> objProf = new ArrayList<>();
        List<Object> objTo = new ArrayList<>();
        
        
        lista = profContr.openFile();
        objTo = profContr.getListObjToSave();
        objProf= profContr.getListProfLinkedCourses();
        for (Object object : objProf) {
            System.out.println("1°" + object.toString());
        }
        for (Object ob : objProf) {
            if (((Professor) ob).getPerson().getSurname().equals(ListProfessor.BRAVETTI.getSurname())) {
                ((Professor) ob).addCourse(new CoursesImpl("questo e il mio corso", Type.FIRST_YEAR));
            }
        }
        
        lista.clear();
        profContr.save(objProf,objTo);
        lista = profContr.openFile();
        objTo = profContr.getListObjToSave();
        objProf= profContr.getListProfLinkedCourses();
        for (Object object : objProf) {
            if(((Professor) object).getPerson().getSurname().equals(ListProfessor.BRAVETTI.getSurname())){
                System.out.println("1°" + object.toString());
            }
           
        }

        /*
         * int x = 1; for (Object ob1 : obj1P) { System.out.println(x + " " +
         * ob1.toString()); x++; }
         * 
         * // per testare la scrittura e salvataggio da file Set<Object> obj1 =
         * new HashSet<>(); // obj = profContr.createNewEmptyList();
         * 
         * profContr.save(obj); obj1 = profContr.openFile();
         * System.out.println("2°" + obj1);
         * 
         * int i = 1; for (Object ob1 : obj1) { System.out.println(i + " " +
         * ob1.toString()); i++; }
         * 
         * // for export in xls type /* ArrayList<String> string = new
         * ArrayList<>(); for (int y = 0; y < 10; y++) {
         * string.add(Integer.toString(y)); } Map<Integer, ArrayList<String>>
         * tmp = new HashMap<>(); tmp.put(1, string); tmp.put(2, string);
         * tmp.put(3, string); tmp.put(4, string); Map<Days, Map<Integer,
         * ArrayList<String>>> finalMap = new HashMap<>(); for (Days d :
         * Days.values()) { finalMap.put(d, tmp); }
         * 
         * modelxls.save(finalMap, finalMap); System.out.println(finalMap);
         */

    }
}
