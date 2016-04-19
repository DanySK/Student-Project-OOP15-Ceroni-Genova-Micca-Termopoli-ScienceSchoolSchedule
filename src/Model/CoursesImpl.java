package Model;

import java.util.Map;

public class CoursesImpl implements Courses{

    private Map<String, Type> map; 
    
    public CoursesImpl(final String name, Type typology){
        this.map.put(name, typology);
    } 
    
    public String getName(String name) {
        String tmp = null;
        for (String i: map.keySet()) {
           if(i.equals(name))
               tmp=i;
        }
        return tmp;
    }
}
