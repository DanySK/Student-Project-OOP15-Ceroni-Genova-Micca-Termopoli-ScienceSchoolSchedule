package Model;

public enum Days {
        MONDAY(0, "Lunedì"),
        TUESDAY(1, "Martedì"), 
        WEDNESDAY(2, "Mercoledì"), 
        THURSDAY(3, "Giovedì"), 
        FRIDAY(4, "Venerdì");
    
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
