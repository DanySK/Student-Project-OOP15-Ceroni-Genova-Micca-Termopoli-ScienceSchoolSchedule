package Model;

public interface Courses {
    String getName(String name);
   
    public enum Type {
        
        FIRST_YEAR(1),
        SECOND_YEAR(2),
        SECOND_YEAR_ENG(4),
        SECOND_YEAR_SCI(5),
        THIRD_YEAR(3),
        THIRD_YEAR_OPT(6),
        THIRD_YEAR_ENG(7),
        THIRD_YEAR_SCI(8);
        
        private final int x;
        
        private Type(Integer i){
            this.x = i;
        }
        
        public int getValue(){
            return this.x;
        }
        
    }

}
