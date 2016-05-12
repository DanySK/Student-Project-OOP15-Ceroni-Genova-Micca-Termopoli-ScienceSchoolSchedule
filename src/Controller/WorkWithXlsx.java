package Controller;

import Model.Professor;
import Model.Room;

public class WorkWithXlsx {
    private static SaveControllerInterface saveContr = new SaveController();
    private static ExportToXlsxInterface modelxls;

    public static void main(String[] args) {

      //  saveContr.createNewEmptyList();
        ObjToSave obj = saveContr.getObjToSave();
        
       /* for (Professor prof : obj.getListProfessor()) {
            System.out.println(prof.toString());
        }*/
        for (Reservation res : obj.getListReservation()) {
            System.out.println(res.toString());
        }
      //  System.out.println(obj.getListProfessor());
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
