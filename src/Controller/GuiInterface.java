package Controller;

import java.util.ArrayList;
import java.util.Map;

import Model.Days;
import Model.Hours;
import Model.ListCourses;
import Model.ListRoom;

public interface GuiInterface {

    public boolean add(ListCourses course, Hours hours, ListRoom clas, Days day );
    
    public Map<ListCourses, Map<Object, ArrayList<String>>> getMapForCourses();
    
    public Map<Hours, Map<Object, String>> getMapForHours();
    
    
}
