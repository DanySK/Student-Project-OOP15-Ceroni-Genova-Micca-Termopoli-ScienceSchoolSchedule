package Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Model.Hours;
import Model.ListCourses;
import Model.ListProfessor;
import Model.ListRoom;

public class WorkWithXlsx {

    private static ObjWorkersInterface model = new ObjWorkers();

    public static void main(String[] args) {

        /*
         * ArrayList<String> string = new ArrayList<>(); for (int y = 0; y < 10;
         * y++) { string.add(Integer.toString(y)); } Map<Integer,
         * ArrayList<String>> tmp = new HashMap<>(); tmp.put(1, string);
         * tmp.put(2, string); tmp.put(3, string); tmp.put(4, string);
         * Map<Days,Map<Integer, ArrayList<String>>> finalMap = new HashMap<>();
         * for (Days d : Days.values()) { finalMap.put(d, tmp); }
         * 
         * model.save(finalMap,finalMap); System.out.println(finalMap);
         */
        Set<ObjToSave> obj = new HashSet<>();
        List<ObjToSave> obj1 = new ArrayList<>();
        ListProfessor[] prof = ListProfessor.values();
        ListCourses[] course = ListCourses.values();
        Hours[] hour = Hours.values();
        ListRoom[] room = ListRoom.values();
        int x = 0;
        int z = 0;
        int c = 0;
        int v = 0;
        for (int y = 0; y < 10; y++) {
            obj1.add(new ObjToSave(prof[x], course[z], hour[c], room[v]));
            x++;
            z++;
            c++;
            v++;
            if (x==prof.length-1)
                x = 0;
            if (z == course.length-1)
                z = 0;
            if (c == hour.length-1)
                c = 0;
            if (v == room.length-1)
                v = 0;
        }
        model.save(obj1);
        System.out.println(obj1);

        obj = model.apri();
        System.out.println("2°" + obj);
        
        
        int i=1;
        for (ObjToSave ob1 : obj) {
            System.out.println(i +" "+ ob1.getProf().toString());
            i++;
        }
    }
}
