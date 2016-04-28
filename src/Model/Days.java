package Model;

public enum Days {
        MONDAY(0, "Luned�"),
        TUESDAY(1, "Marted�"), 
        WEDNESDAY(2, "Mercoled�"), 
        THURSDAY(3, "Gioved�"), 
        FRIDAY(4, "Venerd�");
    
    private final Integer y;
    private final String s;
    
    private Days(Integer l, String m){
        this.y = l;
        this.s = m;
    }
    
    public Integer getValue(){
        return this.y;
    }
    
    public String getString(){
    	return this.s;
    }
}
