package Model;

public enum Days {
        MONDAY(0),
        TUESDAY(1), 
        WEDNESDAY(2), 
        THURSDAY(3), 
        FRIDAY(4);
    
    private final Integer y;
    
    private Days(Integer l){
        this.y = l;
    }
    
    public Integer getValue(){
        return this.y;
    }
}
